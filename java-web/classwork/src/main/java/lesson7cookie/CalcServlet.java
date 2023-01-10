package lesson7cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class CalcServlet extends HttpServlet {

  private final CalcHistory log;

  public CalcServlet(CalcHistory log) {
    this.log = log;
  }

  private Optional<String> safeGet(HttpServletRequest req, String paramName) {
    return Optional.ofNullable(req.getParameter(paramName));
  }

  private Optional<Integer> safeToInt(String raw) {
    try {
      return Optional.of(Integer.parseInt(raw));
    } catch (NumberFormatException x){
      return Optional.empty();
    }
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Cookie[] cs = req.getCookies(); // null !!!
//  String here = req.getContextPath() + req.getRequestURI() + req.getQueryString()
    Optional.ofNullable(cs)
        .flatMap(cc ->
            Arrays.stream(cc).filter(c -> c.getName().equals("id")).findFirst()
        ).ifPresentOrElse(
            c -> {
              //cs.get("check")
              // compare check with check in the DB
              // delete check from db (not to deal with duplicate stuff)
              String userId = c.getValue();
              System.out.println(userId);
              String xs = req.getParameter("x"); // null
              System.out.println(req.getQueryString()); // x=5&y=7
              Map<String, String[]> allParameters = req.getParameterMap();
              Optional<String> oy = safeGet(req, "y");
              Optional<Integer> oyi = oy.flatMap(x -> safeToInt(x));
              int y = oyi.orElse(0);
              int x = Integer.parseInt(xs);
              int z = x + y;

              try (PrintWriter w = resp.getWriter()) {
                log.store(userId, x, y, z);
                w.printf("%d + %d = %d", x, y, z);
              } catch (Exception e) {
                throw new RuntimeException(e);
              }
            },
            () -> {
              System.out.println("CalcServlet.no cookie");
              try {
                resp.sendRedirect("/login"); // "/login" + "?from=" + here
              } catch (IOException e) {
                throw new RuntimeException(e);
              }
            }
        );
  }

}
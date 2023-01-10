package lesson8filter.svt;

import lesson8filter.svc.CalcHistory;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

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
    Cookie c = Optional.ofNullable(req.getCookies())
        .flatMap(cc -> Arrays.stream(cc).filter(c1 -> c1.getName().equals("id")).findFirst()).get();

    String userId = c.getValue();

    String xs = req.getParameter("x");
    String ys = req.getParameter("y");
    int x = Integer.parseInt(xs);
    int y = Integer.parseInt(ys);
    int z = x + y;

    try (PrintWriter w = resp.getWriter()) {
      log.store(userId, x, y, z);
      w.printf("%d + %d = %d", x, y, z);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

}
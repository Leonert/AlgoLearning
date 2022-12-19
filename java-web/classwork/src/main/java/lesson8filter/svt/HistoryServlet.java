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
import java.util.Optional;

public class HistoryServlet extends HttpServlet {

  private final CalcHistory log;

  public HistoryServlet(CalcHistory log) {
    this.log = log;
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Cookie c = Optional.ofNullable(req.getCookies())
        .flatMap(cc -> Arrays.stream(cc).filter(c1 -> c1.getName().equals("id")).findFirst()).get();

    String userId = c.getValue();

    try (PrintWriter w = resp.getWriter()) {
      log.getAll(userId).forEach(s -> w.println(s));
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
package lesson8filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Optional;

public class CheckParamFilter implements HttpFilter {

  @Override
  public void doHttpFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
    try {
      Integer.parseInt(request.getParameter("x"));
      Integer.parseInt(request.getParameter("y"));
      chain.doFilter(request, response);
    } catch (Exception x) {
      try(PrintWriter w = response.getWriter()) {
        w.println("x & y are expected to be int");
      }
      response.setStatus(400);
    }
  }

}

package lesson2;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class StaticContentServlet extends HttpServlet {

  private final String osPrefix;

  public StaticContentServlet(String osPrefix) {
    this.osPrefix = osPrefix;
  }

  // http://localhost:8080/static/images/hp.jpg
  // http://localhost:8080/static/css/1.css
  // http://localhost:8080/static/js/3.js
  // http://localhost:8080/static/3.png
  // http://localhost:8080/static/4.txt
  // http://localhost:8080/static/4.txt
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String pathInfo = req.getPathInfo();
//    System.out.println(pathInfo);
    if (pathInfo.startsWith("/")) pathInfo = pathInfo.substring(1);

    Path file = Path.of(osPrefix, pathInfo);

    try (ServletOutputStream os = resp.getOutputStream()) {
      Files.copy(file, os);
    }
  }

}
package lesson2;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CssServlet extends HttpServlet {

  // http://localhost:8080/table
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Path file = Paths.get("1.css");

    try (ServletOutputStream os = resp.getOutputStream()) {
      Files.copy(file, os);
    }
//    List<String> strings = Files.readAllLines(Paths.get("1.css"));
//
//    try (PrintWriter w = resp.getWriter()) {
//      strings.forEach(x -> w.println(x));
//    }
  }

}
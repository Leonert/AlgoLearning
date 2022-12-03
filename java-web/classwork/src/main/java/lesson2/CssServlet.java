package lesson2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CssServlet extends HttpServlet {

  // http://localhost:8080/
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    List<String> strings = Files.readAllLines(Paths.get("1.css"));


    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    try (PrintWriter w = resp.getWriter()) {
      strings.forEach(x -> w.println(x));
    }
  }

}
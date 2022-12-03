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

public class ImgServlet extends HttpServlet {

  // http://localhost:8080/
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Path file = Paths.get("hp.jpg");

    try (ServletOutputStream os = resp.getOutputStream()) {
      Files.copy(file, os);
    }
  }

}
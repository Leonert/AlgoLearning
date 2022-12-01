package lesson1;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class ServerApp {

  public static void main(String[] args) throws Exception {
    Server server = new Server(8080);

    ServletContextHandler handler = new ServletContextHandler();

    CalcLog log = new CalcHistory();

    handler.addServlet(HelloServlet.class, "/hello");
    handler.addServlet(HandlePostServlet.class, "/post");

    CalcServlet calcServlet = new CalcServlet(log);
    HistoryServlet historyServlet = new HistoryServlet(log);

    handler.addServlet(new ServletHolder(calcServlet), "/calc");
    handler.addServlet(new ServletHolder(historyServlet), "/history");

    server.setHandler(handler);

    server.start();
    server.join();
  }

}

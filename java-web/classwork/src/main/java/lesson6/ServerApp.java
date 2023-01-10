package lesson6;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.function.Function;

public class ServerApp {

  // http://localhost:8080/calc?x=1&y=3
  // http://localhost:8080/calc?x=1&y=4
  // http://localhost:8080/calc?x=1&y=5
  // http://localhost:8080/calc?x=1&y=6
  // http://localhost:8080/history
  public static void main(String[] args) throws Exception {

    // ANTI-PATTERN !!!!
    Connection conn = GlobalSQLConnection.get();
    // ANTI-PATTERN !!!!
    Connection conn2 = GlobalSQLConnection.get();

    Server server = new Server(8080);

    ServletContextHandler handler = new ServletContextHandler();

    CalcHistory log =
//        new CalcInMemoryHistory();
        new CalcSqlHistory(conn);

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

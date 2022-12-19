package lesson8filter;

import lesson8filter.svc.CalcHistory;
import lesson8filter.svc.CalcSqlHistory;
import lesson8filter.svt.*;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import javax.servlet.DispatcherType;
import java.sql.Connection;
import java.util.EnumSet;

public class ServerApp {

  private static final EnumSet<DispatcherType> ft = EnumSet.of(DispatcherType.REQUEST);
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
    handler.addServlet(SetCookieServlet.class, "/login");
    handler.addServlet(RemoveCookieServlet.class, "/logout");

    handler.addFilter(CheckCookieFilter.class, "/calc", ft);
    handler.addFilter(CheckParamFilter.class, "/calc", ft);

    handler.addFilter(CheckCookieFilter.class, "/history", ft);
//    handler.addFilter(new FilterHolder(new CheckCookieFilter(...)), "/calc", ft);

    server.setHandler(handler);

    server.start();
    server.join();
  }

}

package lesson3sql1;

import java.sql.*;

public class SQLApp1 {

  public static void main(String[] args) throws SQLException {
    Connection conn = DriverManager.getConnection(
        "jdbc:postgresql://localhost:5432/fs1",
        "postgres",
        "pg123456"
    );
    PreparedStatement stmt = conn.prepareStatement("select * from account");
    ResultSet rs = stmt.executeQuery();
    while (rs.next()) {
      int id = rs.getInt("id");
      String name = rs.getString("name");
      System.out.printf("id: %d, name: %s\n", id, name);
    }
    conn.close();
  }
}

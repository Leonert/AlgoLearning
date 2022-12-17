package lesson5sql3;

import java.sql.*;

public class SQLApp2 {

  public static void main(String[] args) throws SQLException {
    Connection conn = DriverManager.getConnection(
        "jdbc:postgresql://localhost:5432/fs1",
        "postgres",
        "pg123456"
    );

    PreparedStatement stmt2 = conn.prepareStatement(
        "insert into student (id, name, dob, g) values (?, ?, ?, ?)"
    );

    // start transaction
    conn.setAutoCommit(false);
    try {
      stmt2.setLong(1, 10L);
      stmt2.setString(2, "Jackson10");
      stmt2.setDate(3, Date.valueOf("2022-01-23"));
      stmt2.setInt(4, 20);
      stmt2.execute(); // -> id ???

      if (true) throw new RuntimeException("BOOM!");

      stmt2.setLong(1, 11L);
      stmt2.setString(2, "Jackson11");
      stmt2.setDate(3, Date.valueOf("2022-01-24"));
      stmt2.setInt(4, 21);
      stmt2.execute();
      // fix
      conn.commit();
    } catch (Exception x) {
      // cancel
      conn.rollback();
    }

    PreparedStatement stmt = conn.prepareStatement(
        "select * from student where name like ?"
    );
    stmt.setString(1, "A%");

    ResultSet rs = stmt.executeQuery();
    while (rs.next()) {
      int id = rs.getInt("id");
      String name = rs.getString("name");
      System.out.printf("id: %d, name: %s\n", id, name);
    }
    conn.close();
  }
}

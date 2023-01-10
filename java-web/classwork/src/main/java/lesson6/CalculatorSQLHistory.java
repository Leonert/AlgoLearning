package lesson6;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CalculatorSQLHistory implements CalcHistory {
    Connection connection;

    public CalculatorSQLHistory(Connection connection) {
        this.connection = connection;
    }

    static class Entry {
        final int x, y, z;

        Entry(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    private final List<Entry> storage = new ArrayList<>();

    @Override
    public void store(int x, int y, int z) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("insert into calculations values (?, ?, ?, current_date)");
        statement.setInt(1, x);
        statement.setInt(2, y);
        statement.setInt(3, z);
        statement.execute();
    }

    @Override
    public List<String> getAll() throws SQLException {
        PreparedStatement statement = connection.prepareStatement("select * from calculations");
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        List<String> toReturn = new ArrayList<>();

        while (resultSet.next()) {
            int x = resultSet.getInt("x");
            int y = resultSet.getInt("y");
            int z = resultSet.getInt("z");
            Date date = resultSet.getDate("date");
            toReturn.add(x + " + " + y + " = " + z + ", " + date);
        }
        return toReturn;
    }
}

package Test_DataBase.Test_04;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Test_01 {

    Connection connection;
    Statement statement;
    ResultSet resultSet;

    List<String> credentials = new ArrayList<String>(List.of("jdbc:mysql://127.0.0.1:3306/MyFleet", "root", "root"));

    @BeforeEach
    public void setup() throws SQLException {

        connection = DriverManager.getConnection(credentials.get(0), credentials.get(1), credentials.get(2));
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        resultSet = statement.executeQuery("select *from employees");
    }

    @AfterEach
    public void quit() throws SQLException {
        connection.close();
        statement.close();
        resultSet.close();
    }
    @DisplayName("MyFleet")
    @Test
    public void test01() throws SQLException {

        resultSet.absolute(2);

        System.out.println(resultSet.getString(2));

        statement.executeUpdate("insert into employees (name) value 'Joe'");

    }
}

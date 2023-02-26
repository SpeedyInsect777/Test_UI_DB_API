package Test_DataBase.Test_02;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.*;

public class Test01 {

    Connection connection;
    Statement statement;
    ResultSet resultSet;


    @BeforeEach
    public void setup() throws SQLException, ClassNotFoundException {

        // Class.forName("com.mysql.cj.jdbc.Driver");

        String dbUrl = "jdbc:mysql://127.0.0.1:3306/Fleet";
        String dbUsername = "root";
        String dbPassword = "Prime2022!";

        String allEmployees = "select * from employees";

        String newEmployee = "insert into employees values (103,'Chung','Who','IT Guy')";

        connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        statement.executeUpdate(newEmployee);
        resultSet = statement.executeQuery(allEmployees);

    }

    @AfterEach
    public void quit() {
        try {
            connection.close();
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test01() throws SQLException {

        while (resultSet.next()) {

            System.out.println(resultSet.getString(1));

        }
    }
}

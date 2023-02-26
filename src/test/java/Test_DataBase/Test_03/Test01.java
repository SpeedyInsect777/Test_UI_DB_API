package Test_DataBase.Test_03;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.*;

public class Test01 {

    Connection connection;

    Statement statement;

    ResultSet resultSet;

    String dbUrl = "jdbc:mysql://127.0.0.1:3306/Fleet";

    String dbUsername = "root";

    String dbPassword = "Prime2022!";

    String allTrips = "select * from trip_report";

    String newTrip = "insert into trip_report values (103,'2023-02-02','Springfield IL','Cleveland OH','2023-02-05',999.99)";

    
    @BeforeEach
  public void start() throws SQLException {

        connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);

       statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

       resultSet = statement.executeQuery(allTrips);

  }

@AfterEach
public void quit() throws SQLException {
    connection.close();
    statement.close();
    resultSet.close();
}

    @DisplayName("Adding new Trip")
    @Test
    public void test01() throws SQLException {

        statement.executeUpdate(newTrip);

       while (resultSet.next()) {

           System.out.println(resultSet.getString(2));
       }
    }
    @DisplayName("Adding another trip with User Input")
    @Test
    public void test02(){

    }
}

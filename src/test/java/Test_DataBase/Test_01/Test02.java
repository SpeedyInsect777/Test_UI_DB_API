package Test_DataBase.Test_01;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test02 {
    Connection connection;
    Statement statement;
    ResultSet resultSet;


    @BeforeEach
    public void setup() {

        String dbUrl = "jdbc:oracle:thin:@3.82.233.195:1521:XE";
        String dbUsername = "hr";
        String dbPassword = "hr";

        try {
            connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultSet = statement.executeQuery("select first_name,salary from employees where salary >6000");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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

        List<String> employeesList
                = new ArrayList<>();
       /* while (resultSet.next()) {
            System.out.println(resultSet.getString(2));
        }*/
        for (int k = 1; k <= resultSet.getMetaData().getColumnCount(); k++) {
            System.out.println(k);
            resultSet.beforeFirst();
            while (resultSet.next()) {
               employeesList.add( resultSet.getString(k));

            }
        }
        System.out.println(employeesList);
    }
    @Test
    public void test02() throws SQLException {
        resultSet.beforeFirst();

        List<Map<String,Integer>> lessThanFive = new ArrayList<>();
Map<String,Integer> employeesFive = new HashMap<>();

            resultSet.beforeFirst();
            while (resultSet.next()) {
                 employeesFive.put(resultSet.getString(1),resultSet.getInt(2));



            }
lessThanFive.add(employeesFive);
        System.out.print(lessThanFive.get(0));
    }


}


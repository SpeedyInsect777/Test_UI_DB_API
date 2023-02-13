package Test_DataBase.Test_01;

import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Test01 {
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
            resultSet = statement.executeQuery("select *from employees");
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
        resultSet.next();
        System.out.println(resultSet.getString(2));
        List<String> myList = new ArrayList<>();

        System.out.println("Table: " + resultSet.getMetaData().getColumnName(1));

        myList.add(resultSet.getString(2));
        myList.add(resultSet.getMetaData().getColumnName(1));
        System.out.println(myList.get(0));
        Function<List<String>, Integer> countNum = (x) -> {
            int count = 0;
            for (int k = 0; k < x.size(); k++) {
                System.out.println("k: " + k);
                for (int i = 0; i < x.get(k).length(); i++) {
                    if (x.get(k).charAt(i) == 'e') {
                        count++;
                    }
                }
            }
            return count;
        };
        System.out.println(countNum.apply(myList));
    }

    @Test
    public void test02() throws SQLException {
        resultSet.absolute(9);
        String rowNineColumnThree = resultSet.getString(3);

        Function<String, Integer> countNum = (x) -> {
            int count = 0;
            for (int i = 0; i < x.length(); i++) {

                if (x.charAt(i) == 'e') {
                    count++;
                }
            }
            return count;
        };
        System.out.println(countNum.apply(rowNineColumnThree));
    }
    @Test
    public void test03(){



    }
}
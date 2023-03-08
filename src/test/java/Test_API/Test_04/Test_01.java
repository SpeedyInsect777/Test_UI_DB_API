package Test_API.Test_04;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.*;

import static io.restassured.RestAssured.given;

public class Test_01 {

    Connection connection;
    Statement statement;
    ResultSet resultSet;

    @BeforeEach
    public void setup() {
        RestAssured.baseURI = "http://3.80.111.193:1000/ords/hr";

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

    @Test
    public void test01(){

         given().accept(ContentType.JSON).when().get("/employees/").prettyPeek();



    }


}

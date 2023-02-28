package Test_API.Test_03;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class Test_01 {

    @BeforeEach
    public void setup() {
        RestAssured.baseURI = "http://3.80.111.193:1000/ords/hr";
    }

    @Test
    public void test01() {

      String name =  given().accept(ContentType.JSON).pathParam("employee_id", 102).get("/employees/{employee_id}")
                .jsonPath().getString("first_name");

        System.out.println(name);
    }

}

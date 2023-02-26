package Test_API.Employee_Hr;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class Test01 {
    @BeforeEach
    public void setup() {
        RestAssured.baseURI = "http://3.80.111.193:1000/ords/hr";
    }

    @Test
    public void test01() {

       JsonPath json =  given().accept(ContentType.JSON).pathParam("employee_id", 102).
                when().get("/employees/{employee_id}").
                prettyPeek().then().statusCode(HttpStatus.SC_OK).extract().jsonPath();


        ItemsHR itemsHR = json.getObject("items.[1]",ItemsHR.class);

        System.out.println(itemsHR.getEmail());

    }



}

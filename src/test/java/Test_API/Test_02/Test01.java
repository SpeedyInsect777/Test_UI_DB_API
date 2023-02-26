package Test_API.Test_02;

import Test_API.Employee_Hr.ItemsHR;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;

public class Test01 {



    @BeforeEach
    public void setup() {
        RestAssured.baseURI = "http://3.80.111.193:1000/ords/hr";
    }

    @Test
    public void test01(){

        JsonPath employeeId = given().accept(ContentType.JSON).
                pathParam("employee_id", 102).when().get("/employees/{employee_id}")
                .prettyPeek().jsonPath();

        ItemsHR employeeOneZeroTwo = employeeId.getObject("",ItemsHR.class);

        System.out.println(employeeOneZeroTwo.getEmployee_id());
        String employeeID ="102";

    }
}

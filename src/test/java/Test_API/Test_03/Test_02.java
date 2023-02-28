package Test_API.Test_03;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Test_02 {
    Map<String,Object> objectMap = new HashMap<>();
    Faker faker = new Faker();

    String name = faker.name().firstName();
    String gender = faker.options().option("Male", "Female");
    long phone = Long.parseLong(faker.number().digits(10));

    String apiSpartans = "/api/spartans/";

    String postNewSpartan = "{\n" +
            "\"gender\":\"" + gender + "\",\n" +
            "\"name\":\"" + name + "\",\n" +
            "\"phone\":" + phone + "\n" + "}";

    String putSpartan = "{\n" +
            "\"gender\":\"" + gender + "\",\n" +
            "\"name\":\"" + name + "\",\n" +
            "\"phone\":" + phone + "\n" + "}";

    String patchSpartan = "{\"name\":" + "\"" + name + "\"}";

    @BeforeEach
    public void setup() {
        RestAssured.baseURI = "http://3.82.233.195:8000";
    }

    @DisplayName("Get a Spartan")
    @Test
    public void test01() {
        Response response = given().accept(ContentType.JSON).pathParam("id",3).get("/api/spartans/{id}");

        System.out.println(response.header("Date"));
        String s = response.path("name");
        System.out.println(s);

      //  System.out.println(response.prettyPrint());

        Map<Object, Object> as = response.body().as(Map.class);

        Map<Object, Object> map = response.jsonPath().getMap("");

        System.out.println(as);
        System.out.println(map);
    }

    @Test
    public void test02(){

       Response response = given().contentType(ContentType.JSON).body(postNewSpartan).
               when().post("/api/spartans").
               then().statusCode(HttpStatus.SC_CREATED)
               .extract().response();



  objectMap = response.path("");

        System.out.println(objectMap);

    }
    @Test
    public void test03(){
        JsonPath jsonPath = given().contentType(ContentType.JSON)
                .body(postNewSpartan).when()
                .post("/api/spartans").then().statusCode(HttpStatus.SC_CREATED).extract().jsonPath();

        Map<String,Object> objectMap2 = new HashMap<>();

        objectMap2 = jsonPath.getMap("");

        System.out.println("????"+objectMap2);

    }
    @Test
    public void test04(){

        given().contentType(ContentType.JSON)
                .pathParam("id",159)
                .when().delete("/api/spartans/{id}").then().statusCode(HttpStatus.SC_NO_CONTENT);
    }
    @Test
    public void test05(){
        given().contentType(ContentType.JSON).pathParam("id",156)
                .when().delete("/api/spartans/{id}").then().statusCode(HttpStatus.SC_NO_CONTENT);
    }
}

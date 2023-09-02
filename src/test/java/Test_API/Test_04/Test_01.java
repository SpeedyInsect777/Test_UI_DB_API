package Test_API.Test_04;

import io.cucumber.core.gherkin.messages.internal.gherkin.internal.com.eclipsesource.json.Json;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utilities.DistanceCalculator;

import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.*;

import static io.restassured.RestAssured.given;

public class Test_01 {
    String apiKey = "AIzaSyA43o4dF-2tvOQOX-ZGCdOaSefsjpjKnpU";
    String origin = "Washington, DC";
    String destination = "New York City, NY";
    String urlBase = "https://maps.googleapis.com/maps/api/distancematrix/json\n" +
            "  ?destinations=" + java.net.URLEncoder.encode(origin, "UTF-8") + "\n" +
            "  &origins=" + java.net.URLEncoder.encode(destination, "UTF-8") + "\n" +
            "  &units=imperial\n" +
            "  &key=" + apiKey;

    public Test_01() throws UnsupportedEncodingException {
    }

    //java.net.URLEncoder.encode(origin, "UTF-8")
    @Test
    public void test01() {

        RestAssured.baseURI = urlBase;

        Response response = given().accept(ContentType.JSON)
                .when().get();

        String json = response.jsonPath().getString("rows[0].elements[0].distance.text");


        System.out.println(json);
    }

    @DisplayName("Get Distance")
    @Test
    public void getDistance() throws Exception {

        String origin = "Chicago, IL";
        String destination = "Columbus, OH";

        String apiKey = "AIzaSyCYC2UUYMK8VsOSVq90c-Y4DGMGZ2LdqPM";

        String endpoint = "https://maps.googleapis.com/maps/api/distancematrix/json";
        String parameters = "origins=" + java.net.URLEncoder.encode(origin, "UTF-8") +
                "&destinations=" + java.net.URLEncoder.encode(destination, "UTF-8") +
                "&units=imperial" +
                "&key=" + apiKey;

        URL url = new URL(endpoint + "?" + parameters);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");


        Response response = given().accept(ContentType.JSON)
                .when().get(endpoint + "?" + parameters);

        String res = response.path("rows[0].elements[0].distance.text");

        System.out.println(res);
    }

    @DisplayName("Get DistanceClassTest")
    @Test
    public void test02() {

        DistanceCalculator distanceCalculator = new DistanceCalculator();

        int dis = distanceCalculator.getDistance("Indianapolis, IN", "Columbus, OH");


        System.out.println(dis);


    }

    @Test
    public void test03() {

        final String BASE_URL = "https://restcountries.com/v3.1/name/";


        OkHttpClient client = new OkHttpClient();

        // Replace 'usa' with the desired country name
        String name = "usa";
        String url = BASE_URL + name;

        Request request = new Request.Builder()
                .url(url)
                .build();

        try (okhttp3.Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new RuntimeException("Failed : HTTP error code : " + response.code());
            }

            String responseBody = response.body().string();
            System.out.println(responseBody);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test04() {



        RestAssured.baseURI  = "http://ZiptasticAPI.com/ZIPCODE";



        Response response = given().accept(ContentType.JSON)
                .when().get("43302");

        response.body().prettyPeek();

    }
}
package Test_API.Test_04;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.http.ContentType;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class ZiptasticAPIFetcher {

    public static void main(String[] args) {


                String baseURL = "http://ZiptasticAPI.com/";
                String zipCode = "43302";

                RestAssured.baseURI = baseURL;
                Response response = RestAssured.given()
                        .accept(ContentType.JSON)
                        .get(zipCode);

                // Extract the JSON from the HTML body
                String htmlContent = response.asString();
                Document doc = Jsoup.parse(htmlContent);
                String jsonString = doc.body().text();

        JsonPath jsonPath = JsonPath.from(jsonString);
        String city = jsonPath.getString("city");
        String state = jsonPath.getString("state");

        System.out.println("City: " + city);
        System.out.println("State: " + state);
            }
        }




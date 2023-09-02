package utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.commons.lang3.StringUtils;

import java.net.HttpURLConnection;
import java.net.URL;

import static io.restassured.RestAssured.given;

public class DistanceCalculator {

    public static int getDistance(String origin, String destination) {
        String apiKey = "AIzaSyCYC2UUYMK8VsOSVq90c-Y4DGMGZ2LdqPM";
        String endpoint = "https://maps.googleapis.com/maps/api/distancematrix/json";

        try {
            String parameters = "origins=" + java.net.URLEncoder.encode(origin, "UTF-8") +
                    "&destinations=" + java.net.URLEncoder.encode(destination, "UTF-8") +
                    "&units=imperial" +
                    "&key=" + apiKey;

            URL url = new URL(endpoint + "?" + parameters);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            Response response = given().accept(ContentType.JSON)
                    .when().get(endpoint + "?" + parameters);

            String distanceWithUnits = response.path("rows[0].elements[0].distance.text");
            String numericPortion = StringUtils.substringBefore(distanceWithUnits, " ");

            float resultFloat = Float.parseFloat(numericPortion);
            return Math.round(resultFloat);

        } catch (Exception e) {
            throw new RuntimeException("Error occurred while calculating distance", e);
        }
    }

    public static void main(String[] args) {
        System.out.println(getDistance("Chicago, IL", "New York, NY"));
    }
}

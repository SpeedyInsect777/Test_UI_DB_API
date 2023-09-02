package Test_API.Test_04;


import io.cucumber.core.gherkin.messages.internal.gherkin.internal.com.eclipsesource.json.Json;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class DistanceMatrixAPI {

    private static String getDistance(String origin, String destination, String apiKey) throws Exception {
        String endpoint = "https://maps.googleapis.com/maps/api/distancematrix/json";
        String parameters = "origins=" + java.net.URLEncoder.encode(origin, "UTF-8") +
                "&destinations=" + java.net.URLEncoder.encode(destination, "UTF-8") +
                "&units=imperial" +
                "&key=" + apiKey;

        URL url = new URL(endpoint + "?" + parameters);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");




        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();

        return content.toString();
    }

    @Test
    public void test01() throws Exception {
        System.out.println(getDistance("Chicago, IL", "Columbus, OH", "AIzaSyCYC2UUYMK8VsOSVq90c-Y4DGMGZ2LdqPM"));


    }

}


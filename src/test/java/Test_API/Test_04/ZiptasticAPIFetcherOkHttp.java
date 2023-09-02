package Test_API.Test_04;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import io.restassured.path.json.JsonPath;

import java.io.IOException;

public class ZiptasticAPIFetcherOkHttp {

    public static void main(String[] args) {
        String baseURL = "http://ZiptasticAPI.com/";
        String zipCode = "43302";

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(baseURL + zipCode)
                .get()
                .addHeader("Accept", "application/json")
                .build();

        try {
            Response response = client.newCall(request).execute();

            // Check if response is successful
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }

            // Extract the JSON from the HTML body
            String htmlContent = response.body().string();
            Document doc = Jsoup.parse(htmlContent);
            String jsonString = doc.body().text();

            JsonPath jsonPath = JsonPath.from(jsonString);
            String city = jsonPath.getString("city");
            String state = jsonPath.getString("state");

            System.out.println("City: " + city);
            System.out.println("State: " + state);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

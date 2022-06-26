import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.restassured.http.ContentType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class RestTest {

    private final String token = "AQAAAABiaiIbAAgDJA0Ho6YBy0KznrubXoeXxPE";

    @Test
    public void getFileAndFolder() throws IOException, ParseException {
        String responceBody = given()
                .header("Authorization", "OAuth " + token)
                .baseUri("https://cloud-api.yandex.net/v1/disk/resources/files")
                .contentType(ContentType.JSON)
                .when().get()
                .then().statusCode(200)
                .extract().asString();


        JsonObject obj = new Gson().fromJson(responceBody, JsonObject.class);
        String result = obj.get("items").toString();

        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = (JSONArray) jsonParser.parse(result);

        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject object = (JSONObject) jsonArray.get(i);
            System.out.println(object.get("name"));
        }


    }

}

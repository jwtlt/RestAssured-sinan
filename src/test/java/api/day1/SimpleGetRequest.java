package api.day1;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class SimpleGetRequest {

    String url = "http://3.89.250.133:8000/api/spartans";

    @Test
    public void test(){

        Response response = RestAssured.get(url);

        System.out.println("response.statusCode() = " + response.statusCode());

        response.prettyPrint();

    }
}

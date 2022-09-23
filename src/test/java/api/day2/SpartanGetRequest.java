package api.day2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SpartanGetRequest {

    String url = "http://3.89.250.133:8000";


    @Test
    public void test1(){

        Response response = RestAssured.given().accept(ContentType.JSON)
                .when()
                .get(url + "/api/spartans");

        System.out.println("response.statusCode() = " + response.statusCode());

        System.out.println("response.contentType() = " + response.contentType());

        response.prettyPrint();

        Assertions.assertEquals(response.statusCode(),200);

        Assertions.assertEquals(response.contentType(),"application/json");

    }

    @Test
    public void test2(){

        Response response = RestAssured.given().accept(ContentType.JSON)
                .when()
                .get(url + "/api/spartans/33");

        Assertions.assertEquals(200,response.statusCode());

        Assertions.assertEquals("application/json",response.contentType());

        Assertions.assertTrue(response.body().asString().contains("Wilek"));

    }

    @DisplayName("GET request to /api/hello")
    @Test
    public void test3(){
        //send request and save response inside the response object
        Response response = RestAssured.when().get(url + "/api/hello");

        //verify status code 200
        Assertions.assertEquals(200,response.statusCode());

        //verify content type
        Assertions.assertEquals("text/plain;charset=UTF-8",response.contentType());

        //verify we have headers named date
        //we use hasHeaderWithName method to verify header exist or not - it returns boolean
        Assertions.assertTrue(response.headers().hasHeaderWithName("Date"));

        //how to get and header from response using header key ?
        //we use response.header(String headerName) method to get any header value
        System.out.println("response.header(\"Content-Length\") = " + response.header("Content-Length"));

        System.out.println(response.header("Date"));

        //verify content length is 17
        Assertions.assertEquals("17",response.header("Content-Length"));

        //verify body is "Hello from Sparta"
        Assertions.assertEquals("Hello from Sparta",response.body().asString());

    }
}

package restassured;

import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.core.IsEqual.equalTo;

public class RestAssuredDemoTests {

    @Test
    public void testDemo () {
        Response response = get("https://reqres.in/api/users?page=2");
        System.out.println(response.getBody().asString());
        System.out.println(response.getTime());
        System.out.println(response.getStatusLine());
        System.out.println(response.getHeader("content-type"));

        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void testDemoExtras () {
        baseURI = "https://reqres.in/api";
        given().get("/users?page=2")
                .then()
                .statusCode(200)
                .body("data[1].id", equalTo(8))
                .log()
                .all();
    }

    @Test
    public void testDemoGetRequestExample () {
        baseURI = "https://reqres.in/api";
        given().get("users/2")
                .then()
                .statusCode(200)
                .body("data.first_name", equalTo("Janet"))
                .log()
                .all();
    }

    @Test
    public void testDemoPostRequestExample () {
        baseURI = "https://reqres.in/api";

        Map<String,Object> map = new HashMap<String,Object>();
        JSONObject request = new JSONObject(map);
        request.put("name", "Andrew");
        request.put("job","AQA");

        given()
                .header("content-type","application/json")
                .body(request.toJSONString())
                .when()
                .post("api/users")
                .then()
                .statusCode(201)
                .log()
                .all();
    }

    @Test
    public void testDemoPutRequestExample () {
        baseURI = "https://reqres.in/api";

        Map<String,Object> map = new HashMap<String,Object>();
        JSONObject request = new JSONObject(map);
        request.put("name", "Andrew");
        request.put("job","AQA");

        given()
                .header("content-type","application/json")
                .body(request.toJSONString())
                .when()
                .put("/api/users/2")
                .then()
                .statusCode(200)
                .log()
                .all();
    }

    @Test
    public void testDemoPatchRequestExample () {
        baseURI = "https://reqres.in/api";

        Map<String,Object> map = new HashMap<String,Object>();
        JSONObject request = new JSONObject(map);
        request.put("name", "Andrew");
        request.put("job","AQA");

        given()
                .header("content-type","application/json")
                .body(request.toJSONString())
                .when()
                .patch("/api/users/2")
                .then()
                .statusCode(200)
                .log()
                .all();
    }

    @Test
    public void testDemoDeleteRequestExample () {
        baseURI = "https://reqres.in/api";

        given()
                .when()
                .delete("/api/users/2")
                .then()
                .statusCode(204)
                .log()
                .all();
    }
}

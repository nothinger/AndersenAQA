import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

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
        given().get("/users?page=2").then().statusCode(200).body("data[1].id", equalTo(8)).log().all();
    }
}

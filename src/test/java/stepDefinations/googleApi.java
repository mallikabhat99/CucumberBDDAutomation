package stepDefinations;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Assert;
import pojo.AddPlace;
import pojo.Location;
import resources.TestDataBuild;
import resources.Utils;

import static io.restassured.RestAssured.given;

public class googleApi extends Utils {
    RequestSpecification res;
    ResponseSpecification resSpec;
    Response response;
    TestDataBuild data = new TestDataBuild();

    @Given("Add Place Payload")
    public void add_place_payload() throws IOException {
        res = given().spec(requestSpecification()).body(data.addPlacePayload());
    }

    @When("user calls AddPlaceApi with Post http request")
    public void user_calls_add_place_api_with_post_http_request() {
        resSpec = responseSpecification();
        response = res.when().post("/maps/api/place/add/json").then().spec(resSpec).extract().response();
    }

    @Then("the API call is success with status code {int}")
    public void the_api_call_is_success_with_status_code(Integer int1) {
        Assert.assertEquals(200, response.getStatusCode());
    }

    @And("{string} in response body is {string}")
    public void inResponseBodyIs(String key, String expectedValue) {
        String resp = response.asString();
        JsonPath jsonPath = JsonPath.from(resp);
        Assert.assertEquals(expectedValue, jsonPath.getString(key));
    }


    @When("user calls {string} with Post http request")
    public void userCallsWithPostHttpRequest(String arg0) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}

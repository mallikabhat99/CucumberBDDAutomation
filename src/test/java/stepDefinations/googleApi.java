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
import java.util.Optional;

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
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

import static io.restassured.RestAssured.given;

public class googleApi extends Utils {
    RequestSpecification res;
    ResponseSpecification resSpec;
    Response response;
    static String place_id;
    TestDataBuild data = new TestDataBuild();

    @Given("Add Place Payload with {string} {string} and {string}")
    public void addPlacePayloadWithAnd(String name, String lang, String address) throws IOException {
        res = given().spec(requestSpecification()).body(data.addPlacePayload(name, lang, address));
    }

    @When("user calls {string} with {string} http request")
    public void userCallsWithHttpRequest(String resource, String httpMethod) {
        //constructor of the enum will be called
        APIResources apiResources = APIResources.valueOf(resource);
        switch (httpMethod) {
            case "POST":
                response = res.when().post(apiResources.getResource());
                break;
            case "GET":
                response = res.when().get(apiResources.getResource());
                break;
            case "DELETE":
                response = res.when().delete(apiResources.getResource());
                break;
        }

    }

    @Then("the API call is success with status code {int}")
    public void the_api_call_is_success_with_status_code(Integer statusCode) {
        resSpec = responseSpecification();
        response = response.then().spec(resSpec).extract().response();
        Assert.assertEquals(200, response.getStatusCode());
    }

    @And("{string} in response body is {string}")
    public void inResponseBodyIs(String key, String expectedValue) {
        Assert.assertEquals(expectedValue, getJsonPath(response, key));
    }

    @When("user calls {string} with Post http request")
    public void userCallsWithPostHttpRequest(String arg0) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }


    @And("verify the place_id created maps to {string} using {string}")
    public void verifyThePlace_idCreatedMapsToUsing(String expectedName, String resource) throws IOException {
        place_id = getJsonPath(response, "place_id");
        res = given().spec(requestSpecification()).
                queryParam("place_id", place_id);
        userCallsWithHttpRequest(resource, "GET");
        String actualName = getJsonPath(response, "name");
        Assert.assertEquals(expectedName, actualName);

    }

    @Given("Delete Place Payload")
    public void deletePlacePayload() throws IOException {
        res = given().spec(requestSpecification()).body(data.deletePlacePayload(place_id));
    }
}

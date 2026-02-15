
package com.framework.steps;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.List;

import static org.testng.Assert.*;

public class APITask2_Steps {

    Response response;

    @Given("user hits GET api")
    public void user_hits_get_api() {
        response = RestAssured.get("https://openlibrary.org/authors/OL1A.json");
    }

    @Then("status code should be {int}")
    public void status_code_should_be(Integer code) {
        assertEquals(response.getStatusCode(), code.intValue());
    }

    @Then("Validate response body")
    public void validate_response_body() {
        response.body().prettyPrint();
    }
    @Then("Validate the response body contains name as {string}")
    public void validate_the_response_body_contains_name_as(String p_name) {
       // System.out.println(response.jsonPath().getString("personal_name"));
        assertEquals(response.jsonPath().getString("personal_name"),p_name,"Personal Name is not matching with Expected Value");

    }
    @Then("Validate alternate_names contains {string}")
    public void validate_alternate_names_contains(String a_name) {
        List<String> altNames = response.jsonPath().getList("alternate_names");
        Assert.assertTrue(altNames.contains(a_name), "Name not found in alternate_names");
    }

}

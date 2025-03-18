// Package declaration - groups this class into a specific package
package com.prasad_v.ex_03_GET_Request;

// Importing necessary Rest Assured classes for API testing
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

// Importing TestNG for test execution.
import org.testng.annotations.Test;

// Class definition for the test
public class APITesting008_GET_NonBDDStyle {

    // Declaring variables to store API request, response, and validation
    RequestSpecification r;   // Interface to build and send API requests
    Response response; // Stores the API response
    ValidatableResponse vr; // Used to validate the response

    // ---------------------------- TEST CASE 1: POSITIVE ----------------------------

    @Description("Verify the GET Req Positive") // Allure report description
    @Test // Marks this as a TestNG test case
    public void test_NonBDD_GET() {
        // Define a valid PIN code
        String pincode = "560048";

        // Step 1: Create a request using RestAssured
        r = RestAssured.given(); // Initializes the request specification

        // Step 2: Set the API base URL and endpoint path
        r.baseUri("https://api.zippopotam.us"); // Base URL of the API
        r.basePath("/IN/" + pincode); // Appending the PIN code to form the complete endpoint

        // Step 3: Send the GET request and store the response
        response = r.when().log().all().get(); // Logs request details & sends the request

        // Step 4: Validate the response
        vr = response.then().log().all().statusCode(200); // Logs response and checks if status is 200 OK
    }

    // ---------------------------- TEST CASE 2: NEGATIVE ----------------------------

    @Description("Verify the GET Req Negative : -1 Input") // Allure report description
    @Test // Marks this as a TestNG test case
    public void test_NonBDDStyleGET_negative() {

        // Define an invalid PIN code
        String pin_code = "-1";

        // Step 1: Create a request
        r = RestAssured.given(); // Initializes the request specification

        // Step 2: Set the API base URL and endpoint path
        r.baseUri("https://api.zippopotam.us"); // Base URL of the API
        r.basePath("/IN/" + pin_code); // Appending the invalid PIN code to form the endpoint

        // Step 3: Send the GET request and store the response
        response = r.when().log().all().get(); // Logs request details & sends the request

        // Step 4: Validate the response
        vr = response.then().log().all().statusCode(404); // Logs response and checks if status is 404 Not Found
    }
}

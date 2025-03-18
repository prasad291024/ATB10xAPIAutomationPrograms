package com.prasad_v.ex_06_PATCH_Request;  // Defines the package

// Importing required dependencies
import io.qameta.allure.Description;  // Used for test documentation in Allure Reports
import io.restassured.RestAssured;  // Main Rest Assured class for API requests
import io.restassured.http.ContentType;  // Enum to set request Content-Type
import io.restassured.response.Response;  // Interface to store API response
import io.restassured.response.ValidatableResponse;  // Interface to validate API response
import io.restassured.specification.RequestSpecification;  // Interface for request specification
import org.testng.annotations.Test;  // TestNG annotation for test execution

public class APITesting012_PATCH_NONBddStyle {  // Class definition for PATCH request testing

    @Description("Verify the Patch Request for the Restful Booker APIs")  // Allure test case description
    @Test  // Marks this method as a test case
    public void test_patch_non_bdd() {

        // ✅ Step 1: Define Authentication Token and Booking ID
        String token = "9cc9447e730afc3";  // Authentication token (must be valid)
        String bookingid = "794";  // Booking ID to be updated

        // ✅ Step 2: Define JSON request body (payload) for the PATCH request
        String payloadPatch = "{\n" +
                "    \"firstname\" : \"Pramod\",\n" +
                "    \"lastname\" : \"Brown\"\n" +
                "}";

        // ✅ Step 3: Create Request Specification
        RequestSpecification requestSpecification = RestAssured.given();  // Initialize request
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");  // Set Base URL
        requestSpecification.basePath("/booking/" + bookingid);  // Set API endpoint with booking ID
        requestSpecification.contentType(ContentType.JSON);  // Set Content-Type as JSON

        // ✅ Step 4: Add Authentication Token in Cookie
        requestSpecification.cookie("token", token);  // Add auth token to the request

        // ✅ Step 5: Attach the request body and log the request
        requestSpecification.body(payloadPatch).log().all();

        // ✅ Step 6: Send the PATCH request
        Response response = requestSpecification.when().patch();

        // ✅ Step 7: Validate the response
        ValidatableResponse validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);  // Assert that status code is 200 (Success)
    }
}

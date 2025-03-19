// Package declaration - Groups this class into a specific package
package com.prasad_v.ex_09_Assertions;

// Import required libraries
import io.restassured.RestAssured;  // Main Rest Assured library
import io.restassured.http.ContentType;  // Defines request/response content types
import io.restassured.response.Response;  // Stores the API response
import io.restassured.response.ValidatableResponse;  // Allows validation of API response
import io.restassured.specification.RequestSpecification;  // Defines API request structure
import org.hamcrest.Matchers;  // Provides matchers for assertions
import org.testng.annotations.Test;  // TestNG framework for testing

public class APITesting025_RestAsssured_Assertions {
    RequestSpecification requestSpecification;  // Object to define API request
    ValidatableResponse validatableResponse;  // Object to validate API response
    Response response;  // Object to store API response
    String token;  // Variable to store authentication token
    Integer bookingId;  // Variable to store booking ID

    // Test method for sending POST request
    @Test
    public void test_POST(){

        // Define JSON payload for the request
        String payload_POST = "{\n" +
                "    \"firstname\" : \"Pramod\",\n" +
                "    \"lastname\" : \"Dutta\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : false,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-01-01\",\n" +
                "        \"checkout\" : \"2024-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Lunch\"\n" +
                "}";

        // Step 1: Define Request Specification (Setting up API Request)
        requestSpecification = RestAssured.given();  // Start defining the request
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");  // Set base URI
        requestSpecification.basePath("/booking");  // Set endpoint for creating booking
        requestSpecification.contentType(ContentType.JSON);  // Specify JSON format
        requestSpecification.body(payload_POST).log().all();  // Attach request payload & log request details

        // Step 2: Send POST request
        Response response = requestSpecification.when().post();  // Execute POST request

        // Step 3: Get Validatable Response for validation
        validatableResponse = response.then().log().all();  // Log the full response

        //Assertions (Validation checks)

        // Step 4: Validate Response Status Code
        validatableResponse.statusCode(200);  // Check if response status is 200 OK
        // this is rest assured default assertion

        // Step 5: Perform Assertions to Validate Response Data

        // Validate that 'firstname' is "Pramod"
        validatableResponse.body("booking.firstname", Matchers.equalTo("Pramod"));
        // This ensures that the API correctly returned "Pramod" as the firstname


        // Validate that 'lastname' is "Dutta"
        validatableResponse.body("booking.lastname", Matchers.equalTo("Dutta"));
        // This ensures that the API correctly returned "Dutta" as the lastname

        // Validate that 'totalprice' is 111
        validatableResponse.body("booking.totalprice", Matchers.equalTo(111));
        // This ensures that the API correctly returned 111 as the total price

        // Validate that 'checkin' is "2024-01-01"
        validatableResponse.body("booking.bookingdates.checkin", Matchers.equalTo("2024-01-01"));
        // This ensures that the API correctly returned "2024-01-01" as the check-in date

        // Validate that 'checkout' is "2024-01-01"
        validatableResponse.body("booking.bookingdates.checkout", Matchers.equalTo("2024-01-01"));
        // This ensures that the API correctly returned "2024-01-01" as the check-out date

        // Validate that 'additionalneeds' is "Lunch"
        validatableResponse.body("booking.additionalneeds", Matchers.equalTo("Lunch"));


        // Validate that 'depositpaid' is false
        validatableResponse.body("booking.depositpaid", Matchers.equalTo(false));
        // Ensures the value of "depositpaid" in the response matches expected false

        // Validate that 'bookingid' is not null
        validatableResponse.body("bookingid", Matchers.notNullValue());
        // Ensures that the booking ID is generated and returned successfully (must not be null)

    }
}

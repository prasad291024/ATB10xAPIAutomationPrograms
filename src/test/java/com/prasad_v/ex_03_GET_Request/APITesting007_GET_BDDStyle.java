// Package declaration - organizes the class inside a specific folder structure...
package com.prasad_v.ex_03_GET_Request;

// Importing RestAssured library to perform API testing....
import io.restassured.RestAssured;

// Importing TestNG's @Test annotation to mark this as a test case.
import org.testng.annotations.Test;

// Class definition for the test
public class APITesting007_GET_BDDStyle {

    // ---------------------------- TEST CASE 1: POSITIVE ----------------------------

    // Marks this method as a TestNG test case
    @Test
    public void test_GET_Req_POSITIVE() {
        // Defining a variable for a valid postal code
        String pin_code = "388620";  // A valid PIN code in India.

        // Rest Assured BDD-style API request
        RestAssured
                .given()  // Given: Defines the preconditions (request setup).
                .baseUri("https://api.zippopotam.us")  // Setting the base URL of the API.
                .basePath("/IN/" + pin_code)  // Constructing the complete endpoint dynamically.

                .when()  // When: Sending the API request.
                .log()  // Log request details.
                .all()  // Log everything (headers, body, etc.).
                .get()  // Sending a GET request.

                .then()  // Then: Validate the response.
                .log().all()  // Log response details.
                .statusCode(200);  // Verifying that the response status code is 200 OK.
    }

    // ---------------------------- TEST CASE 2: NEGATIVE ----------------------------

    // Marks this method as a TestNG test case
    @Test
    public void test_GET_Req_NEGATIVE() {
        // Defining a variable for an invalid postal code
        String pin_code = "-1";  // An invalid PIN code.

        // Rest Assured BDD-style API request
        RestAssured
                .given()  // Given: Defines the preconditions (request setup).
                .baseUri("https://api.zippopotam.us")  // Setting the base URL of the API.
                .basePath("/IN/" + pin_code)  // Constructing the complete endpoint dynamically.

                .when()  // When: Sending the API request.
                .log()  // Log request details.
                .all()  // Log everything (headers, body, etc.).
                .get()  // Sending a GET request.

                .then()  // Then: Validate the response.
                .log().all()  // Log response details.
                .statusCode(200);  // Verifying that the response status code is 200 OK.
    }
}

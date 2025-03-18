// Package declaration - organizes the class inside a specific folder structure.
package com.prasad_v.ex_03_GET_Request;

// Importing RestAssured library to perform API testing.
import io.restassured.RestAssured;

// Importing TestNG's @Test annotation to mark this as a test case.
import org.testng.annotations.Test;

// Class definition for the test
public class APITesting006_GET_BDDStyle {

    // Test method to perform GET request in BDD style
    @Test // Marks this method as a TestNG test case.
    public void test_BDD_GET() {

        // Defining a variable for the postal code to be tested
        String pincode = "560016";  // PIN code for which we want to retrieve location details.

        // Rest Assured BDD-style API request
        RestAssured.given()  // Given: Defines the preconditions (request setup).
                .baseUri("https://api.zippopotam.us")  // Setting the base URL of the API.
                .basePath("/IN/" + pincode)  // Appending the PIN code dynamically to the endpoint.

                .when().log().all().get()  // When: Sending a GET request and logging request details.

                .then().log().all().statusCode(200);  // Then: Logging response and verifying status code is 200.
    }
}

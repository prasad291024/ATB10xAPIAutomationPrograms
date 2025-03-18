package com.prasad_v.ex_04_POST_Request;  // Defines package location

import io.qameta.allure.Description;  // For test case description in Allure Reports
import io.restassured.RestAssured;  // Main Rest Assured class
import io.restassured.http.ContentType;  // Enum for specifying content type (e.g., JSON)
import io.restassured.response.Response;  // Interface to store HTTP response
import io.restassured.response.ValidatableResponse;  // Interface to validate response
import io.restassured.specification.RequestSpecification;  // Interface for request specification
import org.testng.annotations.Test;  // TestNG annotation for defining test cases

public class APITesting009_POST_NonBDDStyle {
    RequestSpecification r;  // Stores request specification (headers, body, etc.)
    Response response;  // Stores response after making HTTP request
    ValidatableResponse vr;  // Stores validatable response (for assertions)

    @Description("Verify the POST Req Positive : Create Token")  // Description for Allure reports
    @Test  // Marks this method as a test case
    public void test_POST_NonBDDStyle_Create_Token() {
        // URL, Method, Payload/ body / headers
        // Auth?

        // JSON Payload (Request Body) for authentication
        String payload =  "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        System.out.println(" ----    Part 1 ---- ");  // Log for debugging

        // **Part 1: Preparing the Request**
        r = RestAssured.given();  // Initialize request specification
        r.baseUri("https://restful-booker.herokuapp.com");  // Set Base URI
        r.basePath("/auth");  // Set Endpoint (Base Path)

        r.contentType(ContentType.JSON);  // Set Content-Type as JSON
        r.body(payload).log().all();  // Attach request body and log details

        System.out.println(" ----    Part 2 ---- ");  // Log for debugging

        // **Part 2: Sending the POST Request**
        response = r.when().log().all().post();  // Send POST request and log request details

        System.out.println(" ----    Part 3 ---- ");  // Log for debugging

        // **Part 3: Validating the Response**
        vr = response.then().log().all();  // Log response details
        vr.statusCode(200);  // Validate that status code is 200 (Success)
    }
}

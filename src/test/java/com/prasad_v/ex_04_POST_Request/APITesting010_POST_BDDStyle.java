package com.prasad_v.ex_04_POST_Request;  // Defines the package

import io.qameta.allure.Description;  // Used for test case documentation in Allure Reports
import io.restassured.RestAssured;  // Main Rest Assured class for API requests
import io.restassured.http.ContentType;  // Enum to set request Content-Type
import org.testng.annotations.Test;  // TestNG annotation for test execution

public class APITesting010_POST_BDDStyle {  // Class definition

    @Description("Verify the POST Req Positive")  // Allure test case description
    @Test  // Marks this method as a test case
    public void test_POST_BDDStyle() {

        // JSON request body (payload) with login credentials
        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        // Performing the POST request in BDD Style
        RestAssured.given()  // Start request specification
                .baseUri("https://restful-booker.herokuapp.com")  // Set base URL
                .basePath("/auth")  // Set API endpoint
                .contentType(ContentType.JSON)  // Set Content-Type as JSON
                .log().all().body(payload)  // Log request and attach payload

                .when().log().all().post()  // Send the POST request and log details

                .then().log().all().statusCode(200);  // Validate response (expect 200 OK)
    }
}

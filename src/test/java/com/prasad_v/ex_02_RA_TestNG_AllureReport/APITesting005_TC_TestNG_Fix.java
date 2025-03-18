package com.prasad_v.ex_02_RA_TestNG_AllureReport;  // Defines the package

// Importing required dependencies
import io.qameta.allure.Description;  // Used for test documentation in Allure Reports
import io.restassured.RestAssured;  // Main Rest Assured class for API requests
import org.testng.annotations.Test;  // TestNG annotation for test execution

public class APITesting005_TC_TestNG_Fix {  // Class definition for GET request testing

    @Test  // Marks this method as a test case
    @Description("TC#1 - Verify that the Valid Pincode gives 200 OK")  // Allure test case description
    public void test_GET_Positive_TC1(){
        // ✅ Sending a GET request with a valid PIN code (110048)
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")  // Set Base URL
                .basePath("/IN/110048")  // Set API endpoint with a valid PIN code
                .when()
                .get()  // Execute the GET request
                .then()
                .log().all()  // Log the response
                .statusCode(200);  // Validate response status code is 200
    }

    @Test
    @Description("TC#2 - Verify that the Invalid Pincode gives error")
    public void test_GET_Negative_TC2(){
        // ✅ Sending a GET request with an invalid PIN code (-1)
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")  // Set Base URL
                .basePath("/IN/" + "-1")  // Set API endpoint with an invalid PIN code
                .when()
                .get()  // Execute the GET request
                .then()
                .log().all()  // Log the response
                .statusCode(404);  // Validate response status code is 404 (Not Found)
    }

    @Test
    @Description("TC#3 - Verify that the Invalid Pincode gives 200 OK")
    public void test_GET_Negative_TC3(){
        // ✅ Sending a GET request with an invalid PIN code ($)
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")  // Set Base URL
                .basePath("/IN/" + "$")  // Set API endpoint with an invalid PIN code
                .when()
                .get()  // Execute the GET request
                .then()
                .log().all()  // Log the response
                .statusCode(404);  // Validate response status code is 404 (Not Found)
    }
}

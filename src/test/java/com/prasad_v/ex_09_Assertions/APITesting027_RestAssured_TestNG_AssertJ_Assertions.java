package com.prasad_v.ex_09_Assertions;  // Declaring the package where this class resides.

import io.restassured.RestAssured;  // Importing RestAssured for API testing.
import io.restassured.http.ContentType;  // Importing ContentType to specify request format.
import io.restassured.response.Response;  // Importing Response to handle API responses.
import io.restassured.response.ValidatableResponse;  // Importing ValidatableResponse for validating response.
import io.restassured.specification.RequestSpecification;  // Importing RequestSpecification to set request details.

import org.hamcrest.Matchers;  // Importing Matchers from Hamcrest for response validation.
import org.testng.Assert;  // Importing TestNG's Assert for hard assertions.
import org.testng.annotations.Test;  // Importing Test annotation to define test methods.
import org.testng.asserts.SoftAssert;  // Importing SoftAssert to continue test execution despite assertion failures.

import static org.assertj.core.api.Assertions.*;  // Importing AssertJ for fluent assertion style.

public class APITesting027_RestAssured_TestNG_AssertJ_Assertions {

    // Declaring global variables to be used across different steps of the test.
    RequestSpecification requestSpecification;  // Stores request details like URL, headers, body, etc.
    ValidatableResponse validatableResponse;  // Stores the API response which can be validated.
    Response response;  // Stores the raw API response.
    String token;  // Variable to store token if authentication is needed (not used in this test).
    Integer bookingId;  // Variable to store the booking ID returned in response.

    @Test  // Marking this as a TestNG test method.
    public void test_POST() {  // This test method is responsible for creating a new booking.

        // Step 1: Preparing the request payload (JSON body).
        // This JSON represents the data that will be sent in the API request.
        String payload_POST = "{\n" +
                "    \"firstname\" : \"Pramod\",\n" +  // First name of the booking.
                "    \"lastname\" : \"Dutta\",\n" +  // Last name of the booking.
                "    \"totalprice\" : 123,\n" +  // Total price of the booking.
                "    \"depositpaid\" : false,\n" +  // Indicates if the deposit is paid.
                "    \"bookingdates\" : {\n" +  // Contains check-in and check-out dates.
                "        \"checkin\" : \"2024-01-01\",\n" +
                "        \"checkout\" : \"2024-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Lunch\"\n" +  // Additional requests for the booking.
                "}";

        // Step 2: Setting up the API request.
        requestSpecification = RestAssured.given();  // Initializes the request.
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");  // Sets the base URL.
        requestSpecification.basePath("/booking");  // Defines the specific API endpoint.
        requestSpecification.contentType(ContentType.JSON);  // Specifies that the request body is in JSON format.
        requestSpecification.body(payload_POST).log().all();  // Logs the request payload for debugging.

        // Step 3: Sending the POST request and storing the response.
        Response response = requestSpecification.when().post();  // Executes the HTTP POST request.



        // Step 4: Validating the API response.
        validatableResponse = response.then().log().all();  // Logs the response details for debugging.
        validatableResponse.statusCode(200);  // Asserts that the HTTP response code is 200 (OK).


        // Rest Assured -> import org.hamcrest.Matchers;
        // Matchers.equalto()

        // Step 5: Validating response body values using Rest Assured Matchers (Hamcrest).
        validatableResponse.body("booking.firstname", Matchers.equalTo("Pramod"));  // Checks if firstname matches.
        validatableResponse.body("booking.lastname", Matchers.equalTo("Dutta"));  // Checks if lastname matches.
        validatableResponse.body("booking.depositpaid", Matchers.equalTo(false));  // Checks deposit paid status.
        validatableResponse.body("bookingid", Matchers.notNullValue());  // Ensures booking ID is not null.


        // Step 6: Extracting values from the API response.
        bookingId = response.then().extract().path("bookingid");  // Retrieves booking ID.
        String firstname = response.then().extract().path("booking.firstname");  // Retrieves first name.
        String lastname = response.then().extract().path("booking.lastname");  // Retrieves last name.

        // TestNG Assertions
        // SoftAssert vs
        // HardAssert -
        // This means that if any assertion fails,
        // the remaining statements in that test method will not be executed.

        // Step 7: Validating extracted values using TestNG Hard Assertions.
        Assert.assertNotNull(bookingId);  // Ensures booking ID is not null.
        Assert.assertEquals(firstname, "Pramod");  // Ensures first name is "Pramod".
        Assert.assertEquals(lastname, "Dutta");  // Ensures last name is "Dutta".

        // Step 8: Using Soft Assertions (TestNG) for additional checks.
        SoftAssert softAssert = new SoftAssert();  // Creating an instance of SoftAssert.
        softAssert.assertEquals(firstname, "Jim");  // This assertion will fail, but the test continues.
        softAssert.assertAll();  // Reports all soft assertion failures at the end.


        // AssertJ( 3rd- Lib to Assertions)

        // Step 9: Using AssertJ Fluent Assertions for additional verification.
        assertThat(bookingId).isNotNull().isNotZero().isPositive();  // Ensures booking ID is valid.
        assertThat(firstname).isEqualTo("Pramod").isNotEmpty().isNotBlank().isNotNull();  // Validates first name.

        //        String s = ""; //Empty
        //        String s2 = " "; //Blank

        /*
        Explanation of assertions used:
        - Rest Assured Matchers:
          - `equalTo("Pramod")` → Ensures the firstname is "Pramod".
          - `equalTo("Dutta")` → Ensures the lastname is "Dutta".
          - `notNullValue()` → Ensures the booking ID is not null.

        - TestNG Assertions:
          - Hard Assertions (`Assert.assertEquals()`) → Stops execution immediately if it fails.
          - Soft Assertions (`SoftAssert.assertEquals()`) → Collects failures and reports them at the end.

        - AssertJ Assertions:
          - `isNotNull()` → Ensures booking ID is not null.
          - `isNotZero()` → Ensures booking ID is not zero.
          - `isPositive()` → Ensures booking ID is a positive number.
          - `isEqualTo("Pramod")` → Ensures first name matches expected value.
          - `isNotEmpty()` → Ensures the firstname is not an empty string.
          - `isNotBlank()` → Ensures the firstname is not blank (contains non-whitespace characters).

        */
    }
}
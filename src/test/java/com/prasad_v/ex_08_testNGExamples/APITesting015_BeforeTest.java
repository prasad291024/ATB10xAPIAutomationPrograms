// Package declaration - Groups this class into a specific package
package com.prasad_v.ex_08_testNGExamples;

// Importing TestNG annotations for testing lifecycle management
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

// Class definition for API Testing with TestNG
public class APITesting015_BeforeTest {
    // PUT Request -
    // 1. getToken
    // 2. getBookingId
    // 3. test_PUT ( which will use the above two methods)
    // 4. closeAllThings


    // ---------------------------- PRE-CONDITION METHODS ----------------------------

    @BeforeTest() // Runs BEFORE the test cases (Executed once before all tests)
    public void getToken() {
        System.out.println("1"); // Simulating token generation
    }

    @BeforeTest // Runs BEFORE the test cases (Executed once before all tests)
    public void getBookingID() {
        System.out.println("2"); // Simulating fetching booking ID
    }

    // ---------------------------- TEST METHOD ----------------------------

    @Test // Main test method (Executes after @BeforeTest methods)
    public void test_PUT() {
        // token and BookingID should be used here in an actual test case
        System.out.println("3"); // Simulating PUT API test execution
    }

    // ---------------------------- CLEANUP METHOD ----------------------------

    @AfterTest // Runs AFTER all tests have been executed
    public void closeAllThings() {
        System.out.println("Close"); // Simulating cleanup actions after the test
    }

}
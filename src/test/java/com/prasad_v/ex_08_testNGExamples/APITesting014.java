// Package declaration - Groups this class into a specific package
package com.prasad_v.ex_08_testNGExamples;

// Importing TestNG for test execution
import org.testng.annotations.Test;

// Class definition for TestNG tests
public class APITesting014 {

    // ---------------------------- TEST CASE 1: Normal Method ----------------------------

    // This is a normal method, NOT a TestNG test method because it lacks the @Test annotation.
    public void test_post_request() {
        // This method does not execute as a test since it lacks @Test annotation.
    }

    // ---------------------------- TEST CASE 2: TestNG Method ----------------------------

    @Test // This annotation makes it a TestNG test method.
    public void test_post_request2() {
        // This method will execute as a test case when run using TestNG.
    }
}

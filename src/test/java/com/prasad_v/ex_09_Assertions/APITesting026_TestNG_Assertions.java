package com.prasad_v.ex_09_Assertions;  // Package declaration for organizing the test class

import org.testng.Assert;   // Importing TestNG's Hard Assertion Library
import org.testng.annotations.Test;  // Importing TestNG's @Test annotation
import org.testng.asserts.SoftAssert;  // Importing TestNG's Soft Assertion Library

// Class that contains both Hard and Soft Assertion Examples
public class APITesting026_TestNG_Assertions {

    // 📌 1️⃣ **Hard Assertion Example**
    // - **Purpose**: Stops execution immediately if an assertion fails.
    // - **Use Case**: When a failed test should **not** proceed further.
    @Test  // Marks this as a TestNG test method
    public void test_hardAssertExample() {
        System.out.println("Start of the program");  // Prints message indicating test has started

        Boolean is_neeru_male = false;  // Declaring a boolean variable (not used in assertions here)

        // ❌ Hard Assertion - This will fail because "pramod" ≠ "Pramod" (case-sensitive)
        Assert.assertEquals("pramod", "Pramod");
        // - Expected result: `"Pramod"`
        // - Actual result: `"pramod"`
        // - Since they don't match, **execution stops immediately** here.

        System.out.println("End of the program");
        // ❌ This line will **never execute** if the assertion fails above.
    }

    // 📌 2️⃣ **Soft Assertion Example**
    // - **Purpose**: Allows execution to continue even after assertion failures.
    // - **Use Case**: When multiple validations need to run before marking a test as failed.
    @Test
    public void test_softAssertExample() {
        SoftAssert softAssert = new SoftAssert();  // ✅ Creating SoftAssert object

        // ❌ Soft Assertion - This will fail but will **not** stop execution
        softAssert.assertTrue(false);
        // - Expected: `true`
        // - Actual: `false`
        // - The test does **not stop**, but failure is **logged internally**.

        System.out.println("End of the program");  // ✅ This message **will still print** even after assertion failure

        softAssert.assertAll();
        // 🚀 This statement **forces TestNG to check all assertions** that were logged earlier.
        // - If **any assertion failed**, the test fails here.
        // - If all assertions passed, the test **remains successful**.
    }
}

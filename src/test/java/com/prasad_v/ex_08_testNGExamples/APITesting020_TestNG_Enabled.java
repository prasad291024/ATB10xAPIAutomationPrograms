// Package declaration - Groups this class into a specific package
package com.prasad_v.ex_08_testNGExamples;

// Importing TestNG's Assert and Test annotations
import org.testng.Assert;
import org.testng.annotations.Test;

// Class demonstrating TestNG's "enabled" attribute
public class APITesting020_TestNG_Enabled {

    @Test  // Test case 1 - This test will run
    public void test01() {
        Assert.assertTrue(true);  // Assertion: Passes because the condition is true
    }

    @Test(enabled = false)  // Test case 2 - This test is disabled and will NOT run
    public void test02() {
        Assert.assertTrue(true);  // This test will be skipped
    }

    @Test  // Test case 3 - This test will run
    public void test03() {
        Assert.assertTrue(true);  // Assertion: Passes because the condition is true
    }
}

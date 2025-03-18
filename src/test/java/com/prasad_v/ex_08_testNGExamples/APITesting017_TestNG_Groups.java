// Package declaration - Groups this class into a specific package
package com.prasad_v.ex_08_testNGExamples;

// Importing necessary TestNG classes
import org.testng.Assert;
import org.testng.annotations.Test;

// Class demonstrating TestNG groups and priority-based execution
public class APITesting017_TestNG_Groups {

    // sanity - 1
    // reg -> 3
    // p1 -> 2

    // Test Case 1: Belongs to both "sanity" and "regression" groups with priority 1
    @Test(groups = {"sanity", "reg"}, priority = 1)
    public void test_sanityRun() {
        System.out.println("Sanity");  // Prints "Sanity"
        System.out.println("QA");      // Prints "QA"
        Assert.assertTrue(true);       // Test passes
    }

    // Test Case 2: Belongs to "p1" and "regression" groups with priority 2
    @Test(groups = {"p1", "reg"}, priority = 2)
    public void test_regRun() {
        System.out.println("Reg");     // Prints "Reg"
        Assert.assertTrue(false);      // Test fails
    }

    // Test Case 3: Belongs to "p1" and "regression" groups with priority -1 (executes first)
    @Test(groups = {"p1", "reg"}, priority = -1)
    public void test_smokeRun() {
        System.out.println("Smoke");   // Prints "Smoke"
        Assert.assertTrue(false);      // Test fails
    }

}

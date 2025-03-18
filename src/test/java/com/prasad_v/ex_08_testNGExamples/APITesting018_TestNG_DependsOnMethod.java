// Package declaration - Groups this class into a specific package
package com.prasad_v.ex_08_testNGExamples;

// Importing TestNG classes
import org.testng.Assert;
import org.testng.annotations.Test;

// Class demonstrating TestNG "dependsOnMethods" feature
public class APITesting018_TestNG_DependsOnMethod {

    // First test method that all other tests depend on
    @Test
    public void serverStartedOk() {
        System.out.println("I will run first");  // Prints message
        Assert.assertTrue(true);                 // Test passes
    }

    // Second test method - Depends on "serverStartedOk"
    @Test(dependsOnMethods = "serverStartedOk")
    public void method1() {
        System.out.println("method1");  // Prints "method1"
        Assert.assertTrue(true);        // Test passes
    }

    // Third test method - Also depends on "serverStartedOk"
    @Test(dependsOnMethods = "serverStartedOk")
    public void method2() {
        System.out.println("method2");  // Prints "method2"
        Assert.assertTrue(true);        // Test passes
    }
}


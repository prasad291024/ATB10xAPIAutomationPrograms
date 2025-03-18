// Package declaration - Groups this class into a specific package
package com.prasad_v.ex_08_testNGExamples;

// Importing TestNG annotations
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

// Class demonstrating TestNG parameterization
public class APITesting019_TestNG_Parameter {

    // Test method that accepts a parameter from TestNG XML
    @Parameters("browser")  // Fetches value from the XML file
    @Test
    public void demo1(String value) {  // Takes "browser" value as input
        System.out.println("Demo 1 TC");  // Prints test case execution message

        // Conditional execution based on the browser type
        if(value.equalsIgnoreCase("chrome")){
            System.out.println("Start the Chrome Browser");  // Executes if "chrome" is passed
        }
        if(value.equalsIgnoreCase("firefox")){
            System.out.println("Start the Firefox Browser");  // Executes if "firefox" is passed
        }
    }
}

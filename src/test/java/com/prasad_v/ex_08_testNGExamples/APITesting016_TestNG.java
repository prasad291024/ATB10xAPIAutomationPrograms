// Package declaration - Groups this class into a specific package
package com.prasad_v.ex_08_testNGExamples;

// Importing TestNG framework for test execution
import org.testng.annotations.Test;

// Class for demonstrating TestNG priority in test execution
public class APITesting016_TestNG {

    @Test(priority = 1) // This test runs FIRST since priority is the LOWEST
    public void t1(){
        System.out.println("1"); // Prints "1" to indicate test execution order
    }

    @Test(priority = 3) // This test runs THIRD since priority = 3
    public void t2(){
        System.out.println("3"); // Prints "3"
    }

    @Test(priority = 2) // This test runs SECOND since priority = 2
    public void t3(){
        System.out.println("2"); // Prints "2"
    }

    @Test(priority = 4) // This test runs LAST since priority = 4
    public void t4(){
        System.out.println("4"); // Prints "4"
    }
}

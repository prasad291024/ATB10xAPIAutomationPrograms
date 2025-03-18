// Package declaration - Groups this class into a specific package
package com.prasad_v.ex_08_testNGExamples;

// Import TestNG Annotations
import org.testng.annotations.*;

public class APITesting023_All_Annotations {

    @BeforeSuite  // Executes **once before the entire suite** starts running
    void demo1() {
        System.out.println("BeforeSuite");
    }

    @BeforeTest  // Executes **before any test method in the <test> tag of testng.xml**
    void demo2(){
        System.out.println("BeforeTest");
    }

    @BeforeClass  // Executes **before any method in this class runs**
    void demo3(){
        System.out.println("BeforeClass");
    }

    @BeforeMethod  // Executes **before each @Test method**
    void demo4(){
        System.out.println("BeforeMethod");
    }

    @Test  // The actual test case execution
    void demo5(){
        System.out.println("Test");
    }

    @AfterMethod  // Executes **after each @Test method**
    void demo6(){
        System.out.println("AfterMethod");
    }

    @AfterClass  // Executes **after all test methods in this class have run**
    void demo7(){
        System.out.println("AfterClass");
    }

    @AfterTest  // Executes **after all test methods in the <test> tag of testng.xml**
    void demo8(){
        System.out.println("AfterTest");
    }

    @AfterSuite  // Executes **once after the entire suite has finished running**
    void demo9(){
        System.out.println("AfterSuite");
    }
}

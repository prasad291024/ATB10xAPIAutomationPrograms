package com.prasad_v.ex_08_testNGExamples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting018_TestNG_DependsOnMethod {
    @Test
    public void serverStartedOk() {
        System.out.println("I will run first");
        Assert.assertTrue(true);
    }

    @Test(dependsOnMethods = "serverStartedOk")
    public void method1() {
        System.out.println("method1");
        Assert.assertTrue(true);
    }

    @Test(dependsOnMethods = "serverStartedOk")
    public void method2() {
        System.out.println("method2");
        Assert.assertTrue(true);

    }
}

package com.score.basetest;

import driver.AppFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.score.base.Util;

import java.io.IOException;
import java.net.MalformedURLException;

public class BaseTest {

    @BeforeClass
    public void launchApp() throws MalformedURLException {
        System.out.println("before method");
        AppFactory.launchApp();
    }

    @AfterMethod
    public void closeApp(ITestResult result) throws IOException {
        if(result.getStatus() == ITestResult.FAILURE){
            Util.getScreenshot(result.getTestName());
        }
    }

    @BeforeSuite
    public void serverStart(){
        System.out.println("before suite");
        com.score.base.AppiumServer.start();
    }

    @AfterSuite
    public void serverStop(){
        com.score.base.AppiumServer.stop();
    }
}

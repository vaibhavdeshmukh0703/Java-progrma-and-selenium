package com.example.ScreenShot;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class Implementation extends BaseClass implements ITestListener{
    @Override
       public void onTestFailure(ITestResult result) {
        // TODO Auto-generated method stub After the test is failure
        BaseClass.takeScreenShot(result.getMethod().getMethodName());
           
    }

    @Override
    public void onTestStart(ITestResult result) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void onStart(ITestContext context) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void onFinish(ITestContext context) {
        // TODO Auto-generated method stub
        
    }
}

package com.example.Listner;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public  class ImplimentationLisner  implements ITestListener{

   
    @Override
    public void onFinish(ITestContext context) {
        // TODO Auto-generated method stub  at the End Of test class
    System.out.println("On finish Method");
        
    }

    @Override
    public void onStart(ITestContext context) {
        // TODO Auto-generated method stub Before TEst class execution start.
        System.out.println("onStart Method");
        
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // TODO Auto-generated method stub After the test is failure
        System.out.println("OnTestFailure");
        
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // TODO Auto-generated method stub After test is skeep
        System.out.println("OnTestSkipped");
    }


    @Override
    public void onTestStart(ITestResult result) {
        // TODO Auto-generated method stub Before Test method run
        System.out.println("OnTest Start MEthod");
        
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // TODO Auto-generated method stub After test nethod success
        System.out.println("OnTestSuccess Method");
        
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub
       System.out.println(" onTestFailedButWithinSuccessPercentage method"); 
    }
    
}

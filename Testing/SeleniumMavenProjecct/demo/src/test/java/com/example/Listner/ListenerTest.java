package com.example.Listner;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

// At class Level Listener Implementation
@Listeners(ImplimentationLisner.class)
public class ListenerTest {
    @Test
    public void TestMethod1(){
        System.out.println("From Test Method 1");
    }
     @Test()
    public void TestMethod2() throws InterruptedException{
       
        System.out.println("From Test Method 2");
        Assert.assertTrue(false); 
    }
     @Test(timeOut = 1000)
    public void TestMethod3() throws InterruptedException{
         Thread.sleep(2000);
        System.out.println("From Test Method 3");
    }
     @Test(dependsOnMethods ={"TestMethod3"})
    public void TestMethod4(){
        System.out.println("From Test Method 4");
    }
    
}

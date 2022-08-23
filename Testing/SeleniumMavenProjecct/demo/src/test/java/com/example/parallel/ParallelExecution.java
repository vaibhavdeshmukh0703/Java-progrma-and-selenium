package com.example.parallel;

import org.testng.annotations.Test;

public class ParallelExecution {
   @Test(invocationCount = 4 ,invocationTimeOut = 1000, threadPoolSize = 2)
    public void tetMethod1(){
        System.out.println("Test MEthod 1 >> "+Thread.currentThread().getId());
   } 
   @Test
    public void tetMethod2(){
        System.out.println("Test MEthod 2 >>  "+Thread.currentThread().getId());
   } 
   @Test
    public void tetMethod3(){
        System.out.println("Test MEthod 3 >>  "+Thread.currentThread().getId());
   } 
   @Test
    public void tetMethod4(){
        System.out.println("Test MEthod 4 >>  "+Thread.currentThread().getId());
   } 
}

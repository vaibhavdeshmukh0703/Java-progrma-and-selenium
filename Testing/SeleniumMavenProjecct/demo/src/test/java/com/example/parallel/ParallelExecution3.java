package com.example.parallel;

import org.testng.annotations.Test;

public class ParallelExecution3 {
    @Test
  public void tetMethod8(){
        System.out.println("Test MEthod 8 >>  "+Thread.currentThread().getId());
   } 
   @Test
    public void tetMethod9(){
        System.out.println("Test MEthod 9  >>  "+Thread.currentThread().getId());
   } 
   @Test
    public void tetMethod10(){
        System.out.println("Test MEthod 10 >>  "+Thread.currentThread().getId());
   }    
}

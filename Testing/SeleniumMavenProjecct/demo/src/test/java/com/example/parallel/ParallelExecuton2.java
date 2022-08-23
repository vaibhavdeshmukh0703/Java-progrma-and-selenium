package com.example.parallel;

import org.testng.annotations.Test;

public class ParallelExecuton2 {
    @Test
    public void tetMethod5() {
        System.out.println("Test MEthod 5 >>  " + Thread.currentThread().getId());
    }

    @Test
    public void tetMethod6() {
        System.out.println("Test MEthod 6 >> " + Thread.currentThread().getId());
    }

    @Test
    public void tetMethod7() {
        System.out.println("Test MEthod 78 >>  " + Thread.currentThread().getId());
    }
    @Test
    public void tetMethod8() {
        System.out.println("Test MEthod 79 >>  " + Thread.currentThread().getId());
    }
    @Test
    public void tetMethod9() {
        System.out.println("Test MEthod 710 >>  " + Thread.currentThread().getId());
    }
}

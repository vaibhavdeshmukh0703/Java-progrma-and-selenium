package com.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

public class DataSupplyer {
    @DataProvider(name = "dp2")
    public Iterator<Object[]> dataSupplier1(){
        List<Object[]> dp1 = new ArrayList<>();
        dp1.add(new Object[]{"vai","des"});
        return dp1.iterator();  
    }   
    
    @DataProvider(indices = {1,2}, name="dp3",parallel=true)
    public Iterator<Object[]> dataSupplier2(){
        List<Object[]> l2 = new ArrayList<>();
        l2.add(new Object[]{"Vaibhav",9657});
        l2.add(new Object[]{"Shekhar",9657});
        l2.add(new Object[]{"vishal",9657});
        return l2.iterator();

    }
}


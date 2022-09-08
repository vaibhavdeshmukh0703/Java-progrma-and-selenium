package com.example;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * DataProvider
 */

 public class DataSupplier {
    // -------------------------------Data Provider for single Diamentional
    // array---------------

    // @Test(dataProvider = "dp1")
    // public void login(Object object){
    // System.out.println(object);
    // }
    // @DataProvider(name = "dp1")
    // public Object[] dp1(){
    // Object[] data = new Object[]{
    // "vaibhav",
    // "Deshmukh",
    // "Rahatani"
    // };
    // return data;
    // }

    // -------------------------------Data Provider for Two Diamentional
    // array---------------
    // @Test(dataProvider = "dp1")
    // public void login(Object[] object){
    // System.out.println(object[0]+" >> "+object[1]);
    // }
    // @DataProvider(name = "dp1")
    // public Object[][] dp1(){
    // Object[][] data = new Object[][]{
    // { "vaibhav","deshmukh"},
    // {"Deshmukh","Shekhar"},
    // { "Rahatani","satara"}
    // };
    // return data;
    // }

    // ---------------------------Data Provider for
    // iterator<String>----------------------
    // @Test(dataProvider = "dp1")
    // public void login(String object){
    // System.out.println(object);
    // }
    // @DataProvider(name = "dp1")
    // public Iterator<String> dp1(){
    // List<String> l1= new ArrayList<>();
    // l1.add("vaibhav");
    // l1.add("Deshmukh");
    // return l1.iterator();
    // }

    // ----------------------------Data provider for
    // Iterator<String,String>-------------------

    @Test(dataProvider = "dp1")
    public void login(Object[] object) {
        System.out.println(object[0] + " >> " + object[1]);
    }

    @DataProvider(name = "dp1")
    public Iterator<Object[]> dp1() {
        Set<Object[]> l1 = new HashSet<>();
        l1.add(new Object[] { "vaibhav", 9657 });
        return l1.iterator();
    }

    // ----------------------------Data Provider from DataProvider
    // Class-----------------
    @Test(dataProvider = "dp3", dataProviderClass = DataSupplyer.class)
    public void login1(Object[] object) {
        System.out.println(object[0]+ " "+object[1]);
    }
}

package com.example.Window;

public class Test {
    private int a;
    private String name;

    // Test(int a,String name){
    //     this.a = a;
    //     this.name =name;
    // }
    public void print(){
        System.out.println(a+" " +name);
    }
    public void add(int a, String name){
        this.a= a;
        this.name = name;
        System.out.println(a+"  "+name);
    }
    public static void main(String[] args) {
        Test t = new Test();
      //  t.add(10,"abc");
        t.print();
    }
    
}

package com.spring.test;

class SuperClass1 {
	public void super_print() {
		System.out.println("Super Print");
	}
 
	public void super_show() {
		System.out.println("Super Show");
	}
}
 
public class SubClass1 extends SuperClass1 {
 
	public void sub_print() {
		System.out.println("Sub Print");
	}
 
	public void sub_show() {
		System.out.println("Sub Show");
	}
	
	public static void main(String[] args) {
 
		/* Child class object up cast to super class reference. Using super class reference , sub class object can not use methods
		 of sub class despite of being object of that class. Up casting restricts access or visibility of methods downwards */
		SuperClass1 superClass1 = new SubClass1();
		superClass1.super_print();
		superClass1.super_show();
		
		
		/* To access sub class methods, super class reference needs to be downcast to sub class reference. Note here we can down cast
		to a up cast reference only. */
		SubClass1 subClass1 = (SubClass1)superClass1;
		subClass1.sub_print();
		subClass1.sub_show();
		
		
 
	}
}
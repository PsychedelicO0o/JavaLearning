package com.test.dynamics.test.test;

import java.util.Properties;

public class InitTest {
	
	private static int a = 8 ;
	
	public static void main(String[] args){
		
		InitTest init_1 = new InitTest();
		InitTest init_2 = new InitTest();
		
		init_1.getA();
		init_2.getA();
		
		
		a ++;
		
		
		init_1.getA();
		init_2.getA();
		
		
		Properties p = System.getProperties();
		
		p.list(System.out);
		
		Runtime r = Runtime.getRuntime();
	
		System.out.println(r.totalMemory() +"  +  "+r.freeMemory());
		
		int i = -2;
		i >>>= 2;
		System.out.println(i);
		long l = -2;
		l >>>= 2;
		System.out.println(l);
		short s = -2;
		s >>>= 2;
		System.out.println(s);
		byte b = -2;
		b >>>= 2;
		System.out.println(b);
		
//		putOutNewVariable();
	}
	
	public static void setA(int a){
		
		InitTest.a = a;
	}
	
	public static void getA(){
		
		System.out.println(a);
	}
	
//	private static void putOutNewVariable(){
//		
//		int a ;
//		System.out.println(a);
//	}
	
}

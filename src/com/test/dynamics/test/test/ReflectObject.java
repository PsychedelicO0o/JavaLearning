package com.test.dynamics.test.test;

public class ReflectObject {
	
	private static String a = "737373";
	private String b ;
	private int c ;
	
	public ReflectObject(String b ,int c){
		
		this.b = b;
		this.c = c;
	}
	
	private String getSubString(int a,String temp){
		
		return temp.substring(a);
	}
}

package com.test.dynamics.test.dynamaicprograming;


import java.math.BigInteger;
import java.util.LinkedHashMap;
import java.util.Scanner;

class DynamicTest2 extends DynamicTest1{
	
	
	public String show(DynamicTest1 obj){
		return "DynamicTest2 类 参数为 DynamicTest1 的方法";
	}
	
	public String show(DynamicTest2 obj){
		return "DynamicTest2 类 参数为 DynamicTest2 的方法";
	}
}
class DynamicTest3 extends DynamicTest2{
	
	
}

public class DynamicTest1 {
	static int [] FBNQ = new int [30];
	public String show(DynamicTest3 obj){
		return "DynamicTest1 类 参数为 DynamicTest3 的方法";
	}
	
	public String show(DynamicTest1 obj){
		return "DynamicTest1 类 参数为 DynamicTest1 的方法";
	}
	private void printNothing(){
		System.out.println("nothing");
	}
	
	public static void main(String [] args){
		/*
		DynamicTest1 dt1 = new DynamicTest1();  
		
		DynamicTest1 dt1_2 = new DynamicTest2();  
		
		DynamicTest2 dt2 = new DynamicTest2(); 
		
		dt1_2.printNothing();
		
		 
		
        System.out.println(dt1.show(dt2));    
          
        
        System.out.println(dt1_2.show(dt2));   
		*/
		/*
		
		
		String a ;
		int b = 0;
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			a = sc.nextLine().toLowerCase();
			while(a.contains("doge")){
				b++;
				a = a.replaceFirst("doge", " ");
			}
		} 
		System.out.println(b);
		*/
		System.out.println(getFBNQNumber(0));
		System.out.println(getFBNQNumber(1));
		System.out.println(getFBNQNumber(2));
		System.out.println(getFBNQNumber(3));
		System.out.println(getFBNQNumber(4));
		System.out.println(getFBNQNumber(5));
		System.out.println(getFBNQNumber(6));
		System.out.println(getFBNQNumber(7));
		System.out.println(getFBNQNumber(8));
		System.out.println(getFBNQNumber(9));
		System.out.println(getFBNQNumber(10));
		System.out.println(getFBNQNumber(11));
		System.out.println(getFBNQNumber(12));
		System.out.println(getFBNQNumber(13));
		System.out.println(getFBNQNumber(14));
	}
	public static void sum(int a ){
		if( a % 2 == 1){
			System.out.println(( 1 + a ) / 2 * a);
		}else{
			System.out.println( a / 2 * (1 + a));
		}
		System.out.println();
	}
	/**
	 * 
	 * <p>Discription:[斐波那契数列N项值]</p> 
	 *@param n
	 *@return
	 */
	public static int getFBNQNumber(int n){
		if(n == 0 || n == 1){
		/*	if(FBNQ[n]!=null){
				
			}
		*/
			return n;
		}else{
			return getFBNQNumber(n-1)+getFBNQNumber(n-2);
		}
	}
}


  

    package com.test.dynamics.test.test;
    public class TryCatchFinallyTest {
    	
		private static int i ;
    	public static void main(String [] args){

    		try{
    			System.out.println(args[0]+"  "+args[1]);
    		}catch(ArrayIndexOutOfBoundsException e){
    			System.out.println(e.toString()+"   "+1);
    		}catch(Exception e){
    			System.out.println(e.toString()+"   "+2);
    		}finally{
    			System.out.println("finally   "+3);
    		}
    		System.out.println("   "+4);
    	}
}

  
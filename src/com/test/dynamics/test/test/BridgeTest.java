package com.test.dynamics.test.test;

public class BridgeTest {
	
	abstract class A<T>{
		
		abstract T get(T t);
	}
	
	class B extends A<String>{

		@Override
		String get(String t) {
			// TODO Auto-generated method stub
			return t;
		}
		/* JVM����ʱ��ӵķ���  ���Žӷ�����ͨ���������Ĵ�����Կ��� 
		Object get(Object o){
			
			return (Object)get((String)o);
		}
		*/
	}
	
	class Father{
		
	}
	
	class Son extends Father{
		
	}
	
	interface Human{
		
	}
	
	class Woman implements Human{
		
	}
	
	
	class C{
		
		Father get1(){return new Father();}
		Human get2(){return new Woman();}
	}
	class D extends C{
		
		@Override
		Son get1(){return new Son();}
		
		@Override
		Woman get2(){return new Woman();}
	}
	
	

}

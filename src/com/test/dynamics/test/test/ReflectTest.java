package com.test.dynamics.test.test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectTest {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		
		ReflectObject a = new ReflectObject("ass",8);
		
		Field[] fields = a.getClass().getDeclaredFields();
		
		Method[] methods = a.getClass().getDeclaredMethods();
		int length = fields.length;
		int mLength = methods.length;
		
		for(int i = 0 ; i < length ; i++){
			
			String declareName = fields[i].getName();
			
			if(!fields[i].isAccessible()){
				
				fields[i].setAccessible(true);
			}
			
			Object o = fields[i].get(a);
			System.out.println("�����ԵĶ���������±�����"+declareName+"ֵΪ��"+ o);
		}
		
		for(int j = 0 ; j < mLength ; j ++){
			
			String name = methods[j].getName();
			
			if(!methods[j].isAccessible()){
				
				methods[j].setAccessible(true);
			}
			Class<?>[] z = methods[j].getParameterTypes();
			Object k = methods[j].invoke(a,3,"oeoeoeo");
		
			System.out.println("�����Զ����������Ϊ"+name+"�ķ��� �����Խ��Ϊ"+k.toString());
		}
	}
}

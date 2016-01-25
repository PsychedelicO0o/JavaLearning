
    package com.test.dynamics.test.designpattern.factorymethod;
    public class FactoryMethodTest {
    	
    	public static void main(String[] args){
    		AppleFactory factory = new AppleFactory();
    		factory.produceDevice("iPad").produce();
    		factory.produceDevice("iPhone").produce();
    	}
}

  
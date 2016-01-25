
    package com.test.dynamics.test.designpattern.factorymethod;
    public class AppleFactory {
    	
    	public Apple produceDevice(String name){
    		if(name.equalsIgnoreCase("iPhone")){
    			return new iPhone();
    		}else if(name.equalsIgnoreCase("iPad")){
    			return new iPad();
    		}else{
    			return null;
    		}
    	}
}

  
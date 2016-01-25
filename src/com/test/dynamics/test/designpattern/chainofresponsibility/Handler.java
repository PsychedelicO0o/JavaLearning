
    package com.test.dynamics.test.designpattern.chainofresponsibility;
    public abstract class Handler {
    	
    	Handler successor;
    	
    	public void setSuccessor(Handler successor){
    		this.successor=successor;
    	}
    	public Handler getSuccessor(){
    		return this.successor;
    	}
    	
    	public abstract String handleRequest(String name,int days);
}

  
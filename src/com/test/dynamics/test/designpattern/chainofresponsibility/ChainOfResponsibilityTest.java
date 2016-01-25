
    package com.test.dynamics.test.designpattern.chainofresponsibility;
    public class ChainOfResponsibilityTest {
    	
    	public static void main(String[] args){
    		
    		//先要组装责任链
    		ProjectManager pm = new ProjectManager();
    		DeptManager dm = new DeptManager();
    		GeneralManager gm = new GeneralManager();
    		pm.setSuccessor(dm);
    		dm.setSuccessor(gm);
    		
    		 //开始测试
            String test1 = pm.handleRequest("张三", 2);
            System.out.println("test1 = " + test1);
            String test2 = pm.handleRequest("李四", 2);
            System.out.println("test2 = " + test2);
            System.out.println("---------------------------------------");
            
            String test3 = pm.handleRequest("张三", 4);
            System.out.println("test3 = " + test3);
            String test4 = pm.handleRequest("李四", 4);
            System.out.println("test4 = " + test4);
            System.out.println("---------------------------------------");
            
            String test5 = pm.handleRequest("张三", 6);
            System.out.println("test5 = " + test5);
            String test6 = pm.handleRequest("李四", 6);
            System.out.println("test6 = " + test6);
    	}
}

  
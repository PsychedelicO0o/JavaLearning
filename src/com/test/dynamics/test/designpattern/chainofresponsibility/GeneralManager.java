
    package com.test.dynamics.test.designpattern.chainofresponsibility;
    public class GeneralManager extends Handler{

		@Override
		public String handleRequest(String name, int days) {
			
			if(days>5){
				if(name.equalsIgnoreCase("张三")){
					return "成功：总经理经理同意"+name+"的请假要求，请假天数为："+days;
				}else{
					
					return "失败：总经理经理不同意"+name+"的请假要求";
				}
			}else{
				if(getSuccessor()!=null){
					return getSuccessor().handleRequest(name, days);
				}
				return "";
			}
		}

}

  
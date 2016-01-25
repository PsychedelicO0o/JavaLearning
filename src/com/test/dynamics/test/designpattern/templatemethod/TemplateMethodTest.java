
    package com.test.dynamics.test.designpattern.templatemethod;
    public class TemplateMethodTest extends TemplateMethod{

		@Override
		public void firstStep() {
			
			System.out.println("首先做的事");
			  
		}

		@Override
		public void secondStep() {
			
			System.out.println("其次做的事");
			  
		}

		@Override
		public void thirdStep() {
			
			System.out.println("最后做的事");
			  
		}
		
		public static void main(String[] args){
			TemplateMethodTest a =new TemplateMethodTest();
			
			a.act();
			
		}
}

  
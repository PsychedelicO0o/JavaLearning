
    package com.test.dynamics.test.designpattern.templatemethod;
    /**
     * 
     * <p>Description: [模板方法设计模式]</p> 
     * @category 定义一个操作中的算法的骨架，而将一些步骤延迟到子类中，
     * 				TemplateMethod使得子类可以不改变一个算法的结构即可以重定义该算法得某些特定步骤。 
     * @author BlueWind
     * @version $Revision$ 2014年8月20日
     * @author (lastest modification by $Author$)
     * @since 1.0
     */
    public abstract class TemplateMethod {
    	
    	public abstract void firstStep();
    	
    	public abstract void secondStep();
    	
    	public abstract void thirdStep();
    	
    	public final void act(){
    		firstStep();
    		secondStep();
    		thirdStep();
    	}
}

  
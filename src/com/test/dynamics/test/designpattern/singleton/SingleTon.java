
    package com.test.dynamics.test.designpattern.singleton;
    /**
     * 
     * <p>Description: [单例模式详解]</p> 
     * @category 一个类【有且仅有一个实例】，并且【自行实例化】并【向整个系统提供】
     * @author BlueWind
     * @version $Revision$ 2014年8月15日
     * @author (lastest modification by $Author$)
     * @since 1.0
     * @example 一个系统中可以存在多个打印任务，但是只能有一个正在工作的任务；
     * 			一个系统只能有一个窗口管理器或文件系统；
     * 			一个系统只能有一个计时工具或ID(序号)生成器。如在Windows中就只能打开一个任务管理器。
     * 				如果不使用机制对窗口对象进行唯一化，将弹出多个窗口，如果这些窗口显示的内容完全一致，则是重复对象，浪费内存资源；
     * 				如果这些窗口显示的内容不一致，则意味着在某一瞬间系统有多个状态，与实际不符，也会给用户带来误解，不知道哪一个才是真实的状态
     */
    public class SingleTon {
    	
    	/**第一种模式**/
    	//这个模式(双重锁)将同步内容下方到if内部，提高了执行的效率，
    	//不必每次获取对象时都进行同步，只有第一次才同步，创建了以后就没必要了。
//    	private static SingleTon singleTon = null;
//    	
//    	public static SingleTon getInstance(){
//    		
//    		if(singleTon == null){
//    			synchronized(SingleTon.class){
//    				if(singleTon == null){
//    					singleTon = new SingleTon();
//    				}
//    			}
//    		}
//    		return singleTon;
//    	}
//    	private SingleTon(){
//    		
//    	}
    	/**第一种模式结束**/
    	
    	/**第二种模式 **/
//    	private static SingleTon singleTon = new SingleTon();;
//    	
//    	public static SingleTon getInstance(){
//    		return singleTon;
//    	}
//    	private SingleTon(){
//    		
//    	}
    	/**第二种模式结束**/
    	
    	/**第三种模式**/
    	private static SingleTon singleTon = null;
    	
    	public static synchronized SingleTon getInstance(){
    		if(singleTon ==null){
    			singleTon = new SingleTon();
    		}
    		return singleTon;
    	}
    	private SingleTon(){
    		
    	}
    	
    	/**第三种模式结束**/
    }

  
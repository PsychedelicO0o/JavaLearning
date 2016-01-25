
    package com.test.dynamics.test.designpattern.adapter;
    /**
     * 
     * <p>Description: [测试适配器模式]</p> 
     * @category 测试适配器模式
     * @author BlueWind
     * @version $Revision$ 2014年8月19日
     * @author (lastest modification by $Author$)
     * @since 1.0
     */
    public class TestAdapter {
    	
    	public static void main(String[] args){
    		
    		PS2Port ps2port = new PS2Port(){

				public void usePs2Port() {
					
					 System.out.println("PS2工作中...");
					  
				}
    			
    		};
    		
    		USBPort ps2ToUsb = new PS2ToUsb(ps2port);
    		
    		ps2ToUsb.useUsbPort();
    	}
}

  
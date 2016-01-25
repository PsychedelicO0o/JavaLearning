
    package com.test.dynamics.test.designpattern.adapter;
    /**
     * 
     * <p>Description: [适配器模式ps2TOusb]</p> 
     * @category 适配器模式ps2TOusb
     * @author BlueWind
     * @version $Revision$ 2014年8月19日
     * @author (lastest modification by $Author$)
     * @since 1.0
     */
    public class PS2ToUsb implements USBPort{
    	
    	private PS2Port ps2Port;
		public void useUsbPort() {
			ps2Port.usePs2Port();  
		}
		
		public PS2ToUsb(PS2Port ps2Port){
			this.ps2Port = ps2Port;
		}
}

  
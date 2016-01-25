
    package com.test.dynamics.test.designpattern.abstractfactory;

import com.test.dynamics.test.designpattern.abstractfactory.apple.Apple;
import com.test.dynamics.test.designpattern.abstractfactory.fushikang.FuShiKang;
import com.test.dynamics.test.designpattern.abstractfactory.fushikang.PadFactoryOfFuShiKang;
import com.test.dynamics.test.designpattern.abstractfactory.fushikang.PhoneFactoryOfFuShiKang;
import com.test.dynamics.test.designpattern.abstractfactory.samsung.SamSung;
    public class AbstractFactoryTest {
    	public static void main(String[] args){
    	  
    		FuShiKang phoneFactory = new PhoneFactoryOfFuShiKang();
    		Apple apple = phoneFactory.createApple();
    		apple.getProduction();
    		
    	  
    		FuShiKang padFactory = new PadFactoryOfFuShiKang();
    		SamSung samSung = padFactory.createSamSung();
    		samSung.getProduction();
    	}
}

  
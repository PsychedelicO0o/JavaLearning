
    package com.test.dynamics.test.designpattern.abstractfactory.fushikang;

import com.test.dynamics.test.designpattern.abstractfactory.apple.Apple;
import com.test.dynamics.test.designpattern.abstractfactory.apple.iPhone;
import com.test.dynamics.test.designpattern.abstractfactory.samsung.SamSung;
import com.test.dynamics.test.designpattern.abstractfactory.samsung.SamSungPhone;
    public class PhoneFactoryOfFuShiKang implements FuShiKang {

	public Apple createApple() {
		return new iPhone();
	}

	public SamSung createSamSung() {
		return new SamSungPhone();
	}

}

  
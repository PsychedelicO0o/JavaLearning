
    package com.test.dynamics.test.designpattern.abstractfactory.fushikang;

import com.test.dynamics.test.designpattern.abstractfactory.apple.Apple;
import com.test.dynamics.test.designpattern.abstractfactory.apple.iPad;
import com.test.dynamics.test.designpattern.abstractfactory.samsung.SamSung;
import com.test.dynamics.test.designpattern.abstractfactory.samsung.SamSungPad;
    public class PadFactoryOfFuShiKang implements FuShiKang {

	public Apple createApple() {
		return new iPad();
	}

	public SamSung createSamSung() {
		return new SamSungPad();
	}
}

  
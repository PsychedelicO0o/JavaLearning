package com.test.dynamics.test.designpattern.observer;

/**
 * ����Ĺ۲���
 * @author Psychedelic
 *
 */
public class ConcreteWatcher implements Watcher{


	public void update(String str) {
		// TODO Auto-generated method stub
		System.out.println(this.getClass().getDeclaredAnnotations().toString()+"  ::  "+str);
	}
}

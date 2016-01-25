package com.test.dynamics.test.designpattern.observer;
/**
 * ����������ɫ������ı��۲���
 * @author Psychedelic
 *
 */
public class ConcreteWatched extends Watched{

	@Override
	public void notifyWatchers(String str) {
		// TODO Auto-generated method stub
		for(Watcher o : watcherList){
			
			o.update(str);
		}
	}

}

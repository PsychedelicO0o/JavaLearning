package com.test.dynamics.test.designpattern.observer;
/**
 * 具体的主题角色，具体的被观察者
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

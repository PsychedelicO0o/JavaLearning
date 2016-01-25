package com.test.dynamics.test.designpattern.observer;

public class ObserverTest {
	
	public static void main(String[] args){
		
		//被观察者
		Watched watched = new ConcreteWatched();
		
		
		//观察者
		Watcher watcherA = new ConcreteWatcher();
		Watcher watcherB = new ConcreteWatcher();
		Watcher watcherC = new ConcreteWatcher();
		Watcher watcherD = new ConcreteWatcher();
		Watcher watcherE = new ConcreteWatcher();
		Watcher watcherF = new ConcreteWatcher();
		
		//注册观察者
		watched.addWatcher(watcherF);
		watched.addWatcher(watcherE);
		watched.addWatcher(watcherD);
		watched.addWatcher(watcherC);
		watched.addWatcher(watcherB);
		watched.addWatcher(watcherA);
		
		//被观察者发生变动，广播给所有的观察者
		watched.notifyWatchers("hello stupid boys");
	}

}

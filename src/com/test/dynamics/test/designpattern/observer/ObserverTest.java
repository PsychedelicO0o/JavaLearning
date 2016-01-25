package com.test.dynamics.test.designpattern.observer;

public class ObserverTest {
	
	public static void main(String[] args){
		
		//���۲���
		Watched watched = new ConcreteWatched();
		
		
		//�۲���
		Watcher watcherA = new ConcreteWatcher();
		Watcher watcherB = new ConcreteWatcher();
		Watcher watcherC = new ConcreteWatcher();
		Watcher watcherD = new ConcreteWatcher();
		Watcher watcherE = new ConcreteWatcher();
		Watcher watcherF = new ConcreteWatcher();
		
		//ע��۲���
		watched.addWatcher(watcherF);
		watched.addWatcher(watcherE);
		watched.addWatcher(watcherD);
		watched.addWatcher(watcherC);
		watched.addWatcher(watcherB);
		watched.addWatcher(watcherA);
		
		//���۲��߷����䶯���㲥�����еĹ۲���
		watched.notifyWatchers("hello stupid boys");
	}

}

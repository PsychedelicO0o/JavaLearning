package com.test.dynamics.test.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * ���������ɫ��watched�����۲�
 * @author Psychedelic
 *
 */
public abstract class Watched {
	
	protected List<Watcher> watcherList = new ArrayList<Watcher>();
	
	public synchronized void addWatcher(Watcher watcher){
		
		if(watcher != null){
			
			if(!watcherList.contains(watcher))
				watcherList.add(watcher);
		}
	}
	public synchronized void delWatcher(Watcher watcher){
		
		if(watcher != null){
			
			if(watcherList.contains(watcher))
				watcherList.remove(watcher);
		}
		
	}
	public abstract void notifyWatchers(String str);

}

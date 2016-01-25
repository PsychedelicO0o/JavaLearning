
package com.test.dynamics.test.synch;
/**
 * 
 * <p>Description: [synchronized 
 * 		当两个并发线程访问同一个对象object中的这个synchronized(this)同步代码块时，一个时间内只能有一个线程得到执行。另一个线程必须等待当前线程执行完这个代码块以后才能执行该代码块。
 * 		当两个并发线程访问同一个对象object中的这个synchronized(this)同步代码块时，一个时间内只能由一个线程得到执行，另一个线程必须等待当前线程执行玩这个代码块以后才能执行该代码块。
 * ]</p> 
 * @category 系统_[子系统统名]_[模块名]
 * @author BlueWind
 * @version $Revision$ 2015年3月3日
 * @author (lastest modification by $Author$)
 * @since 1.0
 */
public class FirstThreadForSynchronizedTest implements Runnable{

	public void run() {
		
		System.out.println(Thread.currentThread().getName() + "非同步代码块");
		
		synchronized(this){
			 
			for(int i = 0 ; i < 10 ; i ++){
				 
				System.out.println(Thread.currentThread().getName() + "synchronized loop:" + i);
				try{
					 
					Thread.sleep(500);
				}catch(Exception e){
					 
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args){
		
		FirstThreadForSynchronizedTest loadThread = new FirstThreadForSynchronizedTest();
		
		Thread a = new Thread(loadThread,"first thread: ");
		Thread b = new Thread(loadThread,"second thread: ");
		a.start();
		b.start();
	}
	/**
	 * 输出结果：
	 * 
	  		second thread: 非同步代码块
			first thread: 非同步代码块
			second thread: synchronized loop:0
			second thread: synchronized loop:1
			second thread: synchronized loop:2
			second thread: synchronized loop:3
			second thread: synchronized loop:4
			second thread: synchronized loop:5
			second thread: synchronized loop:6
			second thread: synchronized loop:7
			second thread: synchronized loop:8
			second thread: synchronized loop:9
			first thread: synchronized loop:0
			first thread: synchronized loop:1
			first thread: synchronized loop:2
			first thread: synchronized loop:3
			first thread: synchronized loop:4
			first thread: synchronized loop:5
			first thread: synchronized loop:6
			first thread: synchronized loop:7
			first thread: synchronized loop:8
			first thread: synchronized loop:9

	 */
}

  
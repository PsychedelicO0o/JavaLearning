
package com.test.dynamics.test.synch;
/**
 * 
 * <p>Description: [
		当一个线程访问一个object的同步代码块的时候，另一个线程仍然可以访问该object的其他非同步代码块
		但是该线程对此object中的其他同步代码块的访问将被阻塞
		也就是说当一个线程访问object的一个synchronized(this)同步代码块时，它就获得了这个object的对象锁。结果，其它线程对该object对象所有同步代码部分的访问都被暂时阻塞。
	]</p> 
 * @category 系统_[子系统统名]_[模块名]
 * @author BlueWind
 * @version $Revision$ 2015年3月3日
 * @author (lastest modification by $Author$)
 * @since 1.0
 */
public class SecondThreadForSynchronizedTest {

	public void runFirst(){
		
		synchronized(this){
			
			int i = 5; 
			while(i-- != 0){
				
				System.out.println(Thread.currentThread().getName()+" synchronized loop :" + i);
				try{
					
					Thread.sleep(500);
				}catch( Exception e){
					
					e.printStackTrace();
				} 
			}
		}
	}

	public void runSecond(){
		
		int i = 5; 
		while(i-- != 0){
			
			System.out.println(Thread.currentThread().getName()+"with out synchronized loop :" + i);
			try{
				
				Thread.sleep(500);
			}catch( Exception e){
				
				e.printStackTrace();
			} 
		}
	}
	
	public synchronized void runThird(){
			
		int i = 5; 
		while(i-- != 0){
			
			System.out.println(Thread.currentThread().getName()+"with synchronized loop :" + i);
			try{
				
				Thread.sleep(500);
			}catch( Exception e){
				
				e.printStackTrace();
			} 
		}

	}
	
	public static void main(String[] args){
		
		final SecondThreadForSynchronizedTest load = new SecondThreadForSynchronizedTest();
		
		Thread firstThread = new Thread(new Runnable(){ public void run(){ load.runFirst();}},"firstThread: ");
		Thread secondThread = new Thread(new Runnable(){ public void run(){ load.runSecond();}},"secondThread: ");
		Thread thirdThread = new Thread(new Runnable(){public void run(){load.runThird();}},"thirdThread: ");
		
		firstThread.start();
		secondThread.start();
		thirdThread.start();
		
	}
	/**
	 * 输出结果：
	 		
	 		firstThread:  synchronized loop :4
			secondThread: with out synchronized loop :4
			firstThread:  synchronized loop :3
			secondThread: with out synchronized loop :3
			firstThread:  synchronized loop :2
			secondThread: with out synchronized loop :2
			firstThread:  synchronized loop :1
			secondThread: with out synchronized loop :1
			firstThread:  synchronized loop :0
			secondThread: with out synchronized loop :0
			thirdThread: with synchronized loop :4
			thirdThread: with synchronized loop :3
			thirdThread: with synchronized loop :2
			thirdThread: with synchronized loop :1
			thirdThread: with synchronized loop :0

	 */
}

  
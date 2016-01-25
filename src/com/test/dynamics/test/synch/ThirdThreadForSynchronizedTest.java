
package com.test.dynamics.test.synch;

import java.io.File;
import java.util.Calendar;

public class ThirdThreadForSynchronizedTest {
	
	class Inner{
		
		public void runFirst(){
			
			 int i = 5; 
             while(i-- > 0) { 
            	 
            	 System.out.println(Thread.currentThread().getName() + " : Inner.runFirst()=" + i); 
            	 try { 
            		 
            		 Thread.sleep(500); 
            	 } catch(InterruptedException e) { 
            		 
            		 e.printStackTrace();
            	 } 
             } 
		}
		
		public void runSecond(){
			
			int i = 5; 
			while(i-- > 0) { 
				
				System.out.println(Thread.currentThread().getName() + " : Inner.runSecond()=" + i); 
				try { 
					
					Thread.sleep(500); 
				} catch(InterruptedException e) { 
					
					e.printStackTrace();
				} 
			} 
		}
		
		public void runThird(){
			
			int i = 5; 
			while(i-- > 0) { 
				
				System.out.println(Thread.currentThread().getName() + " : Inner.runThird()=" + i); 
				try { 
					
					Thread.sleep(500); 
				} catch(InterruptedException e) { 
					
					e.printStackTrace();
				} 
			} 
		}
	}
	
	public void runFirst(Inner inner){
		
		synchronized(inner){
			
			inner.runFirst();
		}
	}
	
	public void runSecond(Inner inner){
		
		inner.runSecond();
	}
	
	public void runThird(Inner inner){
		
		synchronized(inner){
			
			inner.runThird();
		}
	}
	
	public static void main(String args[]){
	
		final ThirdThreadForSynchronizedTest load = new ThirdThreadForSynchronizedTest();
		final Inner inner = load.new Inner();
		Thread firstThread = new Thread(new Runnable(){public void run(){load.runFirst(inner);}},"firstThread");
		Thread secondThread = new Thread(new Runnable(){public void run(){load.runSecond(inner);}},"secondThread");
		Thread thirdThread = new Thread(new Runnable(){public void run(){load.runThird(inner);}},"thirdThread");
		firstThread.start();
		secondThread.start();
		thirdThread.start();
	
		System.out.println(System.currentTimeMillis());
		Calendar c = Calendar.getInstance();
		c.set(1970, 0, 1, 8, 0, 0);
		c.set(Calendar.MILLISECOND, 0);
		System.out.println(c.getTimeInMillis());
		File file = new File("");
		
	}

}

  
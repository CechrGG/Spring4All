/**
 * @Title: ThreadTest.java
 * @Package: review.thread
 * @Description: TODO
 *
 */
package review.thread;

/**
 * @author Leslie
 * @version 创建时间：2019年5月30日
 *
 */
public class ThreadTest extends Thread {
	
	private int i = 0;
	
	public void init() {
		ThreadFirst thread1 = new ThreadFirst("ThreadFirst");
		Thread thread2 = new Thread(new ThreadSecond(), "ThreadSecond");
		thread1.start();
		try {
			sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		thread2.start();
	}
	
	public void run() {
		while(true) {
			System.out.println("计数：" + i++);
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public class ThreadFirst extends Thread {
		
		public ThreadFirst(String name) {
			super(name);
		}
		
		public void run() {
			while(true) {
				System.out.println("ThreadFirst: " + i++);
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public class ThreadSecond implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true) {
				System.out.println("ThreadSecond: " + i--);
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

	/**
	 * @author: Leslie
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadTest test = new ThreadTest();
		//test.start();
		test.init();
	}

}

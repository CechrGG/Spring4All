/**
 * @Title: ThreadPoolTest.java
 * @Package: review.thread
 * @Description: TODO
 *
 */
package review.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Leslie
 * @version 创建时间：2019年5月30日
 *
 */
public class ThreadPoolTest {
	
	public void start() {
		ThreadPoolExecutor exe = new ThreadPoolExecutor(5, 10, 100, TimeUnit.MICROSECONDS, 
				new ArrayBlockingQueue<Runnable>(5), new ThreadPoolExecutor.AbortPolicy());
		
		ExecutorService service = Executors.newFixedThreadPool(10);
		
		for(int i = 0; i < 20; i++) {
			Task task = new Task(i);
			exe.execute(task);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("线程池中线程数目：" + exe.getPoolSize() + ", 队列中等待执行任务数目：" + 
								exe.getQueue().size() + ", 已执行完的任务数目：" + exe.getCompletedTaskCount());
		}
		exe.shutdown();
	}
	
	
	
	public class Task implements Runnable {
		
		private int taskId;
		
		public Task(int id) {
			this.taskId = id;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("正在执行任务：" + taskId);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("执行任务" + taskId + "完成");
		}
		
	}

	/**
	 * @author: Leslie
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadPoolTest tp = new ThreadPoolTest();
		tp.start();
	}

}

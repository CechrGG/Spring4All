package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Leslie
 * @version 创建时间：2019年5月8日
 *
 */
public class JavaReview {
	
	/**
	 * strTest
	 */
	private static String strTest = "Hello, Leslie";
	
	private static Logger logger = LogManager.getLogger(JavaReview.class);

	/**
	 * @author: Leslie
	 * @param args
	 * @throws Throwable 
	 */
	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		Character ch = '5';
		System.out.println(Character.isDigit(ch));
		System.out.println(new SimpleDateFormat("yyyy.MM.dd hh:mm:ss").format(new Date(1234567891234L)));
		
		Pattern pattern = Pattern.compile(".*llo(.*?)Leslie");
		Matcher  matcher = pattern.matcher(strTest);
		if(matcher.find()) {
			System.out.println(matcher.groupCount());
			System.out.print("find " + matcher.group(1) + "\n");
		} else {
			System.out.println("Nothing");
		}
		
		JavaReview review = new JavaReview();
		Inner inner1 = review.new Inner(1);
		Inner inner2 = review.getInner(2);
		inner1 = null;
		inner2.finalize();
		System.gc();
		
		/*review.conlInput();
		for(int i = 0; i < 1024*1024; i++) {
			logger.trace("I'm trace");
			logger.debug("I'm debug");
			logger.info("I'm info");
			logger.warn("I'm warn");
			logger.error("I'm error");
			logger.fatal("I'm fatal");
			Thread.sleep(10);
		}*/
	}
	
	public void conlInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			try {
				char c = (char)br.read();
				System.out.print(c);
				if(c == 'q') 
					break;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	
	public Inner getInner(int n) {
		return new Inner(n);
	}
	
	public class Inner {
		private int id;
		public Inner(int n) {
			id = n;
			System.out.println("inner " + id);
		}
		
		protected void finalize() throws Throwable {
			super.finalize();
			System.out.println("Inner " + id + " is disposed");
		}
	}

}

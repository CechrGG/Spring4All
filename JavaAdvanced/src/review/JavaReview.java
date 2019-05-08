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
	
	private static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

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
		
		//review.conlInput();
		
		logger.log(Level.INFO, "Im log");
		logger.debug("Im debug");
		logger.fatal("Im fatal");
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

/**
 * @Title: JavaIO.java
 * @Package: review
 * @Description: TODO
 *
 */
package review;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Leslie
 * @version 创建时间：2019年5月9日
 *
 */
public class JavaIO {

	/**
	 * @author: Leslie
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(System.getProperty("user.dir"));
		File dir = new File(System.getProperty("user.dir") + File.separator + "conf");
		File file = new File(dir.getPath() + File.separator + "conf.properties");
		if(!dir.exists() || !file.exists()) {
			try {
				dir.mkdir();
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		//fileOutputStreamTest(file);
		//fileInputStreamTest(file);
		fileWriter(file);
		fileReader(file);
		
		Scanner scan = new Scanner(System.in);
		while(scan.hasNextLine()) {
			String str = scan.nextLine();
			if(!str.equals("quit")) {
				System.out.println("next:" + str);
			} else {
				break;
			}
		}
	}
	
	/**
	 * @author: Leslie
	 */
	public static void fileInputStreamTest(File file) {
		try {
			FileInputStream fis = new FileInputStream(file);
			byte[] buf = new byte[1024];
			int read = 0;
			while((read = fis.read(buf)) > 0) {
				System.out.println(new String(buf, 0, read));
			}
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void fileOutputStreamTest(File file) {
		try {
			FileOutputStream fos = new FileOutputStream(file);
			byte[] buf = {0x60,0x61, 0x31, 0x32};
			fos.write(buf);
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void fileReader(File file) {
		try {
			FileReader fr = new FileReader(file);
			char[] buf = new char[512];
			int read = 0;
			while((read = fr.read(buf)) > 0) {
				System.out.println(new String(buf, 0, read));
			}
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void fileWriter(File file) {
		try {
			FileWriter fw = new FileWriter(file);
			fw.write("我的妈啊\r\n");
			fw.write("这TMD也行\r\n");
			//fw.flush();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

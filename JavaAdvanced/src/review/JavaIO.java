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
import java.io.IOException;

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
		fileOutputStreamTest(file);
		fileInputStreamTest(file);
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
			byte[] buf = {'a', 'b', 'c', (byte)1, (byte)2};
			fos.write(buf);
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

/**
 * @Title: DataStructure.java
 * @Package: review
 * @Description: TODO
 *
 */
package review;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @author Leslie
 * @version 创建时间：2019年5月23日
 *
 */
public class DataStructure {
	
	private enum Color {
		RED("红"),GREEN("绿"),BLUE("蓝");
		private final String color;
		private Color(String color) {
			this.color = color;
		}
		/**
		 * @return the color
		 */
		public String getColor() {
			return color;
		}
	};
	

	/**
	 * @author: Leslie
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector<String> vector = new Vector<String>();
		for(int i = 0; i < 10; i++) {
			vector.add("0^0 " + i + ",");
		}
		Enumeration<String> colors = vector.elements();
		while(colors.hasMoreElements()) {
			System.out.print(colors.nextElement());
		}
		
		for(int i = 0; i < Color.values().length; i++) {
			System.out.println(Color.values()[i].getColor());
		}
	}

}

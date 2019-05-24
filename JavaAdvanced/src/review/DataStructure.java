/**
 * @Title: DataStructure.java
 * @Package: review
 * @Description: TODO
 *
 */
package review;

import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
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
	
	public static void vecTest() {
		Vector<String> vector = new Vector<String>();
		for(int i = 0; i < 10; i++) {
			vector.add("0^0 " + i + ",");
		}
		Enumeration<String> colors = vector.elements();
		while(colors.hasMoreElements()) {
			System.out.print(colors.nextElement());
		}
	}
	
	public static void stackTest() {
		Stack<String> stack = new Stack<String>();
		
		stack.push("Holdooor");
		stack.push("Brannnn");
		stack.push("youKnowNothing");
		stack.add("Johnnnn");
		System.out.println(stack.peek());
		for(String str : stack) {
			System.out.println(str);
		}
		
		int size = stack.size();
		//这里直接用stack.size()进行循环则不对
		for(int i = 0; i < size; i++) {
			System.out.print(stack.pop() + "$");
		}
	}
	
	public static void listTest() {
		//ArrayList<Integer> list = new ArrayList<Integer>();
		
		LinkedList<Integer> list = new LinkedList<Integer>();

		long sum = 0;
		long timeStart = System.currentTimeMillis();
//		for(int i = 0; i < list.size(); i++) {
//			sum += list.get(i);
//		}
//		for(Integer i : list) {
//			sum += i;
//		}
		Iterator<Integer> iter = list.iterator();
		while(iter.hasNext()) {
			sum += iter.next();
		}
		System.out.println(sum);
		long timeEnd = System.currentTimeMillis();
		System.out.println("take " + (timeEnd-timeStart) + "ms");
	}
	

	/**
	 * @author: Leslie
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		vecTest();
		
		for(int i = 0; i < Color.values().length; i++) {
			System.out.println(Color.values()[i].getColor());
		}
		
//		stackTest();
		listTest();
	}

}

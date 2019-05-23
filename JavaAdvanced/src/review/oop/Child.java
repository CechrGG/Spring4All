/**
 * @Title: Child.java
 * @Package: review.oop
 * @Description: TODO
 *
 */
package review.oop;

/**
 * @author Leslie
 * @version 创建时间：2019年5月23日
 *
 */
public class Child extends Father implements Human{
	
	public Child(String name, int age) {
		super(name, age);
	}
	
	public void say() {
		System.out.println("I'm " + getName() + ", Fucking yourself! I'm your father!");
	}
	
	public void happy() {
		System.out.println("Fucking yourself, hahaha!");
	}

	/**
	 * @author: Leslie
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

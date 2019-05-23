/**
 * @Title: Father.java
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
public class Father extends AbstractAncestor{
	
	private String name;
	private int age;
	
	public Father(String name, int age) {
		System.out.println("I'm " + name + " ," + age);
		this.name = name;
		this.age = age;
	}
	
	public void say() {
		System.out.println("I'm " + name + " , your father, call me daddy!");
	}

	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @author: Leslie
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void happy() {
		// TODO Auto-generated method stub
		System.out.println("I'm your Father. I'm so happy");
	}

}

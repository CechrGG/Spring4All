/**
 * 
 */
package review.oop;

/**
 * @author Leslie
 * @version 创建时间：2019年5月8日
 *
 */
public class ObjectOriented {
	
	public static String name = "objectOriented";

	/**
	 * 
	 */
	public ObjectOriented() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractAncestor dad = new Father("guo", 54);
		AbstractAncestor son = new Child("erduo", 29);
		AbstractAncestor grandSon = new GrandChild("dier", 3);
		dad.say();
		son.say();
		grandSon.say();
		dad.happy();
		son.happy();
		grandSon.happy();

	}

	@Override
	public String toString() {
		return "ObjectOriented [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

}

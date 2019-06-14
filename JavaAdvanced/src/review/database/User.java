/**
 * @Title: User.java
 * @Package: review.database
 * @Description: TODO
 *
 */
package review.database;

/**
 * @author Leslie
 * @version 创建时间：2019年6月12日
 *
 */
public class User {
	
	private int user_id;
	private String user_name;
	private String password;
	private byte age;
	private String email;
	private String phone;
	private String create_time;
	private String modify_time;
	
	public User() {
		
	}
	
	public User(String name, String password, String createTime) {
		//this.userId = id;
		this.user_name = name;
		this.password = password;
		this.create_time = createTime;
	}
	/**
	 * @return the userId
	 */
	public int getUserId() {
		return user_id;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.user_id = userId;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return user_name;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.user_name = userName;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the age
	 */
	public byte getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(byte age) {
		this.age = age;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the createTime
	 */
	public String getCreateTime() {
		return create_time;
	}
	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(String createTime) {
		this.create_time = createTime;
	}
	/**
	 * @return the modifyTime
	 */
	public String getModifyTime() {
		return modify_time;
	}
	/**
	 * @param modifyTime the modifyTime to set
	 */
	public void setModifyTime(String modifyTime) {
		this.modify_time = modifyTime;
	}

	@Override
	public String toString() {
		return "User [userId=" + user_id + ", userName=" + user_name + ", password=" + password + ", age=" + age
				+ ", email=" + email + ", phone=" + phone + ", createTime=" + create_time + ", modifyTime=" + modify_time
				+ "]";
	}

}

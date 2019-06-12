/**
 * @Title: Role.java
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
public class Role {
	
	private int roleId;
	private String roleName;
	private String desc;
	public Role() {
		
	}
	
	public Role(String name, String desc) {
		//this.roleId = id;
		this.roleName = name;
		this.desc = desc;
	}
	/**
	 * @return the roleId
	 */
	public int getRoleId() {
		return roleId;
	}
	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	/**
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}
	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}
	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + ", desc=" + desc + "]";
	}
	

}

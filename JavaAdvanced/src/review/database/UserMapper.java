/**
 * @Title: UserMapper.java
 * @Package: review.database
 * @Description: TODO
 *
 */
package review.database;

import java.util.List;

import org.apache.ibatis.annotations.Select;

/**
 * @author Leslie
 * @version 创建时间：2019年6月14日
 * 接口注解的方式固然方便，但重新又将sql写进代码中，回到过去，得不偿失
 * XML配置方便复杂sql,利于维护和团队协作，因此可以放弃注解方式了
 *
 */
public interface UserMapper {
	//@Select("select * from t_user where user_id= #{id}")
	public User getUserById(int id);
	
	public List<User> getUserList();
	
	public void insertUser(User user);
	
	public void updateUser(User user);
	
	public void deleteUserById(int id);
	
}

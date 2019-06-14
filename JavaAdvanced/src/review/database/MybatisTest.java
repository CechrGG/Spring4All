/**
 * @Title: MybatisTest.java
 * @Package: review.database
 * @Description: TODO
 *
 */
package review.database;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

/**
 * @author Leslie
 * @version 创建时间：2019年6月13日
 *
 */
public class MybatisTest {
	
	private static Reader reader;
	private static SqlSessionFactory sqlSessionFactory;
	
	public static void init() {
		try {
			reader = Resources.getResourceAsReader("mybatis.cfg.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void mybatis() {
		
		init();
		SqlSession sqlSession = null;
		try {	
		//sqlSessionFactory.getConfiguration().addMapper(UserMapper.class);
		sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.getUserById(1);
		List<User> users = userMapper.getUserList();
		for(User usr : users) {
			System.out.println(usr.toString());
		}
		//User user = (User) sqlSession.selectOne("review.database.UserMapper.GetUserById", 1);
		if(user != null) {
			System.out.println(user.toString());
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
	}
}

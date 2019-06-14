/**
 * @Title: MybatisTest.java
 * @Package: review.database
 * @Description: TODO
 *
 */
package review.database;

import java.io.IOException;
import java.io.Reader;

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
	
	@Test
	public void mybatis() {

		try {
		Reader reader = Resources.getResourceAsReader("mybatis.cfg.xml");
		
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		//sqlSessionFactory.getConfiguration().addMapper(UserMapper.class);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		//User user = userMapper.getUserById(1);
		User user = (User) sqlSession.selectOne("review.database.UserMapper.GetUserById", 1);
		if(user != null) {
			System.out.println(user.toString());
		}
		sqlSession.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

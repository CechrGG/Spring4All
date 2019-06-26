/**
 * @Title: RedisTest.java
 * @Package: review.nosql
 * @Description: TODO
 *
 */
package review.nosql;

import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author Leslie
 * @version 创建时间：2019年6月26日
 *
 */
public class RedisTest {
	
	@Test
	public void redis() {
		Jedis jedis = new Jedis("192.168.76.100");
		//System.out.println(jedis.configGet("*"));
		System.out.println(jedis.hgetAll("user"));
		jedis.close();
	}
	
	@Test
	public void jedisPool() {
		JedisPoolConfig jpc = new JedisPoolConfig();
		//最大闲置个数
		jpc.setMaxIdle(30);
		//最小闲置个数
		jpc.setMinIdle(10);
		//最大连接数
		jpc.setMaxTotal(100);
		//创建连接池
		JedisPool jedisPool = new JedisPool(jpc, "192.168.76.100");
		Jedis jedis = jedisPool.getResource();
		System.out.println(jedis.hgetAll("user"));
		jedisPool.close();
	}

}

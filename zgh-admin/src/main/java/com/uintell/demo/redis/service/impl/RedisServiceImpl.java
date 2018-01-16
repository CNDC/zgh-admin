package com.uintell.demo.redis.service.impl;

import com.uintell.demo.redis.JedisUtil;
import com.uintell.demo.redis.service.IRedisService;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Protocol;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service("redisService")
public class RedisServiceImpl implements IRedisService {
	// 调用成功标识
	private static final String IS_OK = Protocol.Keyword.OK.name();
	
	public boolean put2Cache(String key, String value){
		String result = JedisUtil.getCluster().set(key, value);
		return IS_OK.equals(result);
	}
	
	public boolean put2Cache(String key, String value, int seconds){
		String result = JedisUtil.getCluster().setex(key, seconds, value);
		return IS_OK.equals(result);
	}
	
	public boolean put2Cache(byte[] key, byte[] value){
		String result = JedisUtil.getCluster().set(key, value);
		return IS_OK.equals(result);
	}
	
	public boolean put2Cache(byte[] key, byte[] value, int seconds){
		String result = JedisUtil.getCluster().setex(key, seconds, value);
		return IS_OK.equals(result);
	}
	
	public String getFromCache(String key){
		return JedisUtil.getCluster().get(key);
	}
	
	public byte[] getFromCache(byte[] key){
		return JedisUtil.getCluster().get(key);
	}
	
	public long incr(String key){
		return JedisUtil.getCluster().incr(key);
	}
	
	public long incr(byte[] key){
		return JedisUtil.getCluster().incr(key);
	}
	
	public long decr(String key){
		return JedisUtil.getCluster().decr(key);
	}

	public long decr(byte[] key){
		return JedisUtil.getCluster().decr(key);
	}

	public String putMap(String key, Map<String, String> map){
		return JedisUtil.getCluster().hmset(key, map);
	}

	public String putMap(byte[] key, Map<byte[], byte[]> map){
		return JedisUtil.getCluster().hmset(key, map);
	}

	public Map<String, String> getMap(String key){
		return JedisUtil.getCluster().hgetAll(key);
	}
	
	public Map<byte[], byte[]> getMap(byte[] key){
		return JedisUtil.getCluster().hgetAll(key);
	}
	
	public Long lpush(String key, String... values){
		return JedisUtil.getCluster().lpush(key, values);
	}
	
	public Long rpush(String key, String... values){
		return JedisUtil.getCluster().rpush(key, values);
	}
	
	public String lpop(String key){
		return JedisUtil.getCluster().lpop(key);
	}
	
	public String rpop(String key){
		return JedisUtil.getCluster().rpop(key);
	}
	public Long zadd(String key, double score, String member){
		return JedisUtil.getCluster().zadd(key, score, member); 
	}

	public Set<String> zrevrangeByScore(String key, double max, double min)
			 {
		return JedisUtil.getCluster().zrevrangeByScore(key, max, min);
	}

	public Long zrem(String key, String... member){
		return JedisUtil.getCluster().zrem(key, member);
	}

	public void delFromCache(String key){
		JedisUtil.getCluster().del(key);
	}

	public Long hset(String key, String field, String value){
		return JedisUtil.getCluster().hset(key, field, value);
	}

	public String hget(String key, String field){
		return JedisUtil.getCluster().hget(key, field);
	}

	public Long hsetnx(String key, String field, String value){
		return JedisUtil.getCluster().hsetnx(key, field, value);
	}

	public String hmset(final String key, final Map<String, String> hash){
		return JedisUtil.getCluster().hmset(key, hash);
	}

	public List<String> hmget(final String key, final String... fields){
		return JedisUtil.getCluster().hmget(key, fields);
	}
	
	/**
	 * 获取当前key的失效时间
	 */
	public Long getTtl(String key){
		return JedisUtil.getCluster().ttl(key);
	}
	
	/**
	 * 设置过期时间
	 * @param key
	 * @param seconds
	 * @return
	 */
	public Long setExpire(String key, int seconds){
		return JedisUtil.getCluster().expire(key, seconds);
	}
}

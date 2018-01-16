package com.uintell.demo.redis.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Redis服务类接口
 */
public interface IRedisService {

	/**
	 * 放入缓存,永久生效
	 * 
	 * @param key
	 *            缓存key值
	 * @param value
	 *            缓存的value值
	 * @throws Exception
	 * @ReturnType true=成功
	 */
	public boolean put2Cache(String key, String value);

	/**
	 * 放入缓存,并设置生效时间
	 * 
	 * @param key
	 *            缓存的key值
	 * @param value
	 *            缓存的value值
	 * @param seconds
	 *            失效时间(单位秒)
	 * @ReturnType true=成功
	 */
	public boolean put2Cache(String key, String value, int seconds);

	/**
	 * 放入缓存,永久生效
	 * 
	 * @param key
	 *            缓存key值
	 * @param value
	 *            缓存的value值
	 * @throws Exception
	 * @ReturnType true=成功
	 */
	public boolean put2Cache(byte[] key, byte[] value) ;
	
	/**
	 * 放入缓存,并设置生效时间
	 * 
	 * @param key
	 *            缓存的key值
	 * @param value
	 *            缓存的value值
	 * @param seconds
	 *            失效时间(单位秒)
	 * @ReturnType true=成功
	 */
	public boolean put2Cache(byte[] key, byte[] value, int seconds) ;
	
	/**
	 * 从缓存中获取信息
	 * 
	 * @param key
	 *            缓存的key值
	 * @return 根据key取到的值
	 * @throws Exception
	 * @ReturnType String
	 */
	public String getFromCache(String key);
	
	/**
	 * 从缓存中获取信息
	 * 
	 * @param key
	 *            缓存的key值
	 * @return 根据key取到的值
	 * @throws Exception
	 * @ReturnType String
	 */
	public byte[] getFromCache(byte[] key);
	
	/**
	 * 递增序列
	 * 
	 * @param key
	 *            缓存的key值
	 * @return
	 * @throws Exception
	 * @ReturnType long
	 */
	public long incr(String key);

	/**
	 * 递增序列
	 * 
	 * @param key
	 *            缓存的key值
	 * @return
	 * @throws Exception
	 * @ReturnType long
	 */
	public long incr(byte[] key);
	
	/**
	 * 递减序列
	 * 
	 * @param key
	 *            缓存的key值
	 * @return
	 * @throws Exception
	 * @ReturnType long
	 */
	public long decr(String key);

	/**
	 * 递减序列
	 * 
	 * @param key
	 *            缓存的key值
	 * @return
	 * @throws Exception
	 * @ReturnType long
	 */
	public long decr(byte[] key);
	
	/**
	 * 将Map放入缓存
	 * 
	 * @param key
	 *            缓存的key值
	 * @param map
	 *            待放入的值
	 * @return "OK" 成功
	 * @throws Exception
	 */
	public String putMap(String key, Map<String, String> map);

	/**
	 * 将Map放入缓存
	 * 
	 * @param key
	 *            缓存的key值
	 * @param map
	 *            待放入的值
	 * @return "OK" 成功
	 * @throws Exception
	 */
	public String putMap(byte[] key, Map<byte[], byte[]> map);
	
	/**
	 * 从缓存中读取map
	 * 
	 * @param key
	 *            缓存的key值
	 * @return 如果存在key值，则返回Map对象，如果不存在，则返回null
	 * @throws Exception
	 */
	public Map<String, String> getMap(String key);

	/**
	 * 从缓存中读取map
	 * 
	 * @param key
	 *            缓存的key值
	 * @return 如果存在key值，则返回Map对象，如果不存在，则返回null
	 * @throws Exception
	 */
	public Map<byte[], byte[]> getMap(byte[] key);
	
	/**
	 * 进栈、入队  (可以把堆栈看作是一个从左至右的数组。如果左边压栈，右边出栈，那就是队列的入队/出队操作；如果左边压栈，左边出栈，那就是堆栈操作。)
	 * 
	 * @param key
	 *            缓存的key值
	 * @param values
	 *            push的值
	 * @return 存放的条数
	 * @throws Exception
	 */
	public Long lpush(String key, String... values);

	/**
	 * 出栈    (可以把堆栈看作是一个从左至右的数组。如果左边压栈，右边出栈，那就是队列的入队/出队操作；如果左边压栈，左边出栈，那就是堆栈操作。)
	 * 
	 * @param key
	 *            缓存的key值
	 * @param values
	 *            push的值
	 * @return 存放的条数
	 * @throws Exception
	 */
	public String lpop(String key);
	
	/**
	 * 出队       (可以把堆栈看作是一个从左至右的数组。如果左边压栈，右边出栈，那就是队列的入队/出队操作；如果左边压栈，左边出栈，那就是堆栈操作。)
	 * 
	 * @param key
	 *            缓存的key值
	 * @param values
	 *            push的值
	 * @return 存放的条数
	 * @throws Exception
	 */
	public String rpop(String key);
	/**
	 * 操作有序的Set
	 * @param key 缓存的key值
	 * @param score 分值，根据这个进行排序
	 * @param member 存储的值
	 * @return
	 * @throws Exception
	 */
	public Long zadd(String key, double score, String member);
	
	/**
	 * 取分数在min和max之间的值
	 * 
	 * @param key
	 *            缓存的key值
	 * @param max
	 *            分数最大值
	 * @param min
	 *            分数最小值
	 * @return Set<String member>
	 * @throws Exception
	 */
	public Set<String> zrevrangeByScore(String key, double max, double min);
	
	/**
	 * 从set中删除键=key并且value=member的值，可以一次删除多行
	 * 
	 * @param key
	 *            主键
	 * @param member
	 *            待删除的值
	 * @return
	 * @throws Exception
	 */
	public Long zrem(String key, String... member);
	

	/**
	 * 根据key从缓存中删除
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public void delFromCache(String key);  

	public Long hset(String key, String field, String value) ;

	public String hget(String key, String field) ;

	public Long hsetnx(String key, String field, String value) ;

	public String hmset(final String key, final Map<String, String> hash) ;

	public List<String> hmget(final String key, final String... fields) ;
	
	public Long getTtl(String key);
	
	public Long setExpire(String key, int seconds);
	
}


package com.hua.iotdevice.cache;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;


/**
 * 缓存操作接口
 */
public interface Cache {

	/**
	 * 列出所有的key
	 * @return
	 */
	public Set<String> getKeys();


	public Set<String> getKeys(String pattern);

	/**
	 * 检查给定key是否存在
	 *
	 * @param key
	 * @return
	 */
	public Boolean exists(String key);


	/**
	 * 移除给定的一个或多个key。如果key不存在，则忽略该命令。
	 *
	 * @param key
	 */
	public void del(String key);


	/**
	 * 简单的字符串设置
	 *
	 * @param key
	 * @param value
	 */
	public void set(String key, String value);

	/**
	 *
	 * @param key
	 * @param value
	 * @param expiration
	 */
	public void set(String key, String value, Integer expiration);

	/**
	 * 返回key所关联的字符串值
	 *
	 * @param key
	 * @return
	 */
	public String get(String key);



	/**
	 * key seconds 为给定key设置生存时间。当key过期时，它会被自动删除。
	 *
	 * @param key
	 * @param expire
	 */
	public void expire(String key, int expire);


	/**
	 * 如果key已经存在并且是一个字符串，APPEND命令将value追加到key原来的值之后。
	 *
	 * @param key
	 * @param value
	 */
	public void append(String key, String value);




	/**
	 * 获取旧值返回新值，不存在返回nil
	 *
	 * @param key
	 * @param newValue
	 * @return 旧值
	 */
	public String getset(String key, String newValue);

	/**
	 * 分布锁
	 *
	 * @param key
	 * @param value
	 * @return
	 */
	public boolean setnx(String key, String value);


	/**
	 * 计数器
	 */
	public Long incrBy(String key, Long delta);


	/**
	 * list
	 * 添加元素
	 * @param key
	 * @param value
	 * @return
	 */
	public Long leftPush(String key, String value);

	/**
	 * list
	 * 弹出最右边的元素，弹出之后该值在列表中将不复存在
	 * @param key
	 * @return
	 */
	String rpop(String key);


	/**
	 * list
	 * 弹出最右边的元素，如果列表没有元素会阻塞列表直到等待超时或发现可弹出元素为止。
	 * @param key
	 * @param timeout
	 * @param timeUnit  是java.util.concurrent包下面的一个类，表示给定单元粒度的时间段TimeUnit.SECONDS //秒
	*  @return
	 */
	String brpop(String key, long timeout, TimeUnit timeUnit);


	/**
	 *
	 * 返回列表 key 中指定区间内的元素，区间以偏移量 start 和 stop 指定。
	 * 下标(index)参数 start 和 stop 都以 0 为底。也就是说，以 0 表示列表的第一个元素，以 1 表示列表的第二个元素，以此类推。
	 * 你也可以使用负数下标，以 -1 表示列表的最后一个元素， -2 表示列表的倒数第二个元素，以此类推。
	 * @param key
	 * @param start  开始位置
	 * @param end  结束位置
	 * @return
	 */
	List<String> range(String key, long start, long end);

	Long increment(String key);

	/**
	 *
	 * 根据参数 count 的值，移除列表中与参数 value 相等的元素。
	 * 	count 的值可以是以下几种：
	 * 	count > 0 : 从表头开始向表尾搜索，移除与 value 相等的元素，数量为 count 。
	 * 	count < 0 : 从表尾开始向表头搜索，移除与 value 相等的元素，数量为 count 的绝对值。
	 * 	count = 0 : 移除表中所有与 value 相等的值。
	 * @param key
	 * @param count
	 * @param value
	 * @return
	 */
	Long lrem(String key, long count, Object value);

	/**
	 *  添加hash
	 * @param key
	 * @param hashKey
	 * @param value
	 * @author:陈曾杰
	 * @date:2018年11月30日 下午9:22:34
	 */
	public void hset(String key, String hashKey, String value);

	/**
	 * 同时将多个 field-value (字段-值)对设置到哈希表中
	 * @param key
	 * @param map
	 * @author:陈曾杰
	 * @date:2018年11月28日 下午4:56:24
	 */
	public void hmset(String key, Map<String, String> map);

	/**
	 * 返回哈希表中指定字段的值
	 * @param key
	 * @param hashKey
	 * @author:陈曾杰
	 * @return
	 * @date:2018年11月28日 下午4:56:24
	 */
	public Object hget(String key, String hashKey);
	
	/**
	 * 删除hash值
	 * @param key
	 * @param hashKey
	 * @author:陈曾杰
	 * @date:2018年11月30日 下午9:29:16
	 */
	public void hdel(String key, Object hashKey);
}

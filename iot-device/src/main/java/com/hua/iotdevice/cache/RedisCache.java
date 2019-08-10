package com.hua.iotdevice.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;


@Service
public class RedisCache implements Cache {

	@Autowired
	private StringRedisTemplate redisTemplate;

	public RedisCache(StringRedisTemplate redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	@Override
	public Set<String> getKeys(String pattern) {
		return redisTemplate.keys(pattern);
	}

	@Override
	public Set<String> getKeys() {
		return getKeys("*");
	}

	@Override
	public Boolean exists(String key) {
		return redisTemplate.hasKey(key);
	}

	@Override
	public void del(String key) {
		redisTemplate.delete(key);
	}

	@Override
	public void set(String key, String value) {
		redisTemplate.opsForValue().set(key, value);
	}

	@Override
	public void set(String key, String value, Integer expire) {
		redisTemplate.opsForValue().set(key, value, expire, TimeUnit.SECONDS);
	}

	@Override
	public String get(String key) {
		return redisTemplate.opsForValue().get(key);
	}

	@Override
	public void expire(String key, int expire) {
		redisTemplate.expire(key, expire, TimeUnit.SECONDS);
	}

	@Override
	public void append(String key, String value) {
		redisTemplate.opsForValue().append(key, value);
	}

	@Override
	public String getset(String key, String newValue) {
		return redisTemplate.opsForValue().getAndSet(key, newValue);
	}

	@Override
	public boolean setnx(String key, String value) {
		return redisTemplate.opsForValue().setIfAbsent(key, value);
	}

	@Override
	public Long incrBy(String key, Long delta) {
		return redisTemplate.opsForValue().increment(key, delta);
	}
	
	@Override
	public Long leftPush(String key, String value) {
		return redisTemplate.opsForList().leftPush(key, value);
	}
	
	@Override
	public List<String> range(String key, long start, long end){
		return redisTemplate.opsForList().range(key, start, end);
	}

	@Override
	public String rpop(String key) {
		return redisTemplate.opsForList().rightPop(key);
	}
	
	@Override
	public String brpop(String key,long timeout,TimeUnit timeUnit) {
		return redisTemplate.opsForList().rightPop(key, timeout, timeUnit);
	}

	@Override
	public Long increment(String key){
		return redisTemplate.opsForValue().increment(key, 1);
	}

	@Override
	public Long lrem(String key, long count, Object value) {
		return redisTemplate.opsForList().remove(key, count, value);
	}
	@Override
	public void hmset (String key,Map<String,String> map) {
		redisTemplate.opsForHash().putAll(key, map);
	}

	@Override
	public Object hget(String key, String hashKey) {
		return redisTemplate.opsForHash().get(key, hashKey);
	}

	@Override
	public void hset(String key, String hashKey,String value) {
		 redisTemplate.opsForHash().put(key, hashKey, value);
	}
	

	@Override
	public void hdel(String key, Object hashKey) {
		 redisTemplate.opsForHash().delete(key, hashKey);
	}
}

package com.fuyoukache.pubsub;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisUtil {
  private static volatile JedisUtil jedisUtil;
  private JedisPool jedisPool = this.initConfig();

  public JedisPool initConfig() {
    JedisPoolConfig config = new JedisPoolConfig();
    config.setMaxIdle(20);
    config.setMaxTotal(256);
    return new JedisPool(config,"www.erlie.cc", 6379);
  }

  public Jedis getRedisClient() {
    return jedisPool.getResource();
  }

  public static JedisUtil getInstance() {
    if (jedisUtil == null) {
      synchronized (JedisUtil.class) {
        if (jedisUtil == null) {
          jedisUtil = new JedisUtil();
        }
      }
    }
    return jedisUtil;
  }
}
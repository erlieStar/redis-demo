package com.fuyoukache.pubsub;

import redis.clients.jedis.Jedis;

public class Publisher {

  public void publishMsg(String channel, String msg) {
    Jedis jedis = JedisUtil.getInstance().getRedisClient();
    jedis.publish(channel, msg);
  }
}

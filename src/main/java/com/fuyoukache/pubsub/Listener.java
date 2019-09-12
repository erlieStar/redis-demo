package com.fuyoukache.pubsub;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

public class Listener extends JedisPubSub {

  @Override
  public void onMessage(String channel, String message) {
    System.out.println(channel + " " + message);
  }

  public void subscribe(String channel) {
    Jedis jedis = JedisUtil.getInstance().getRedisClient();
    jedis.subscribe(this, channel);
  }
}

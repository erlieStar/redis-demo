package com.fuyoukache.pubsub;

public class Main {

  public static final String CHANNEL_NAME = "demo_channel";

  public static void main(String[] args) {
    Listener listener = new Listener();
    listener.subscribe(CHANNEL_NAME);
    Publisher publisher = new Publisher();
    publisher.publishMsg(CHANNEL_NAME, "hello world");
  }
}

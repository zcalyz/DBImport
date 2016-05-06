package com.zc.kafka;

import java.util.Date;
import java.util.Properties;
import java.util.Random;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

public class ProducerDemo {
	public static String topic = "proTopic1";
	
	public static void main(String[] args) {
		long events = 2;
		System.out.println(events);

		Random rnd = new Random();
		Properties props = new Properties();
		props.put("metadata.broker.list", "10.10.105.96:9092,10.10.105.96:9093");
		props.put("serializer.class", "kafka.serializer.StringEncoder");
		props.put("partitioner.class", "com.zc.kafka.SimplePartitioner");
		props.put("request.required.acks", "1");
		
		ProducerConfig config = new ProducerConfig(props);
		Producer<String, String> producer = new Producer<String,String>(config);
		
		for(int nEvents = 0; nEvents < events; nEvents++){
			long runtime = new Date().getTime();
			String ip = "192.168.2." + rnd.nextInt(255);
			String msg = runtime + ",www.com," + ip;
			KeyedMessage<String, String> keyedMessage = new KeyedMessage<String, String>(topic, ip, msg);
			producer.send(keyedMessage);
		}
	}
}

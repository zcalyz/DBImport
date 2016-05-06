package com.zc.kafka;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;

import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import kafka.serializer.StringDecoder;
import kafka.utils.VerifiableProperties;

public class ConsumerDemo {
	private ConsumerConnector consumer;

	public ConsumerDemo() {
		// TODO Auto-generated constructor stub
		Properties properties = new Properties();
		properties.put("zookeeper.connect", "10.10.105.96:2181");
		properties.put("group.id", "jd-group");

		properties.put("zookeeper.session.timeout.ms", "4000");
		properties.put("zookeeper.sync.time.ms", "200");
		properties.put("auto.commit.interval.ms", "1000");
		properties.put("auto.offset.reset", "smallest");
		// 序列化类
		properties.put("serializer.class", "kafka.serializer.StringEncoder");
		ConsumerConfig config = new ConsumerConfig(properties);
        consumer = kafka.consumer.Consumer.createJavaConsumerConnector(config);
	}
	
	public void consume(){
		Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
        topicCountMap.put(ProducerDemo.topic, new Integer(1));

        StringDecoder keyDecoder = new StringDecoder(new VerifiableProperties());
        StringDecoder valueDecoder = new StringDecoder(new VerifiableProperties());

        Map<String, List<KafkaStream<String, String>>> consumerMap = 
                consumer.createMessageStreams(topicCountMap,keyDecoder,valueDecoder);
        KafkaStream<String, String> stream = consumerMap.get(ProducerDemo.topic).get(0);
        ConsumerIterator<String, String> it = stream.iterator();
        while (it.hasNext())
            System.out.println(it.next().message());
	}
	
	public static void main(String[] args) {
		new ConsumerDemo().consume();
	}
}

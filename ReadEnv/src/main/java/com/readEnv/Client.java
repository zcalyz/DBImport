package com.readEnv;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.gson.Gson;

public class Client {
	public static void main(String[] args) {
		TestObj testObj = new TestObj();
		testObj.setBrokers("10.10.105.96:9092,10.10.105.96:2181");
		testObj.setZookeeper("10.10.105.96:2181");
		Gson gson = new Gson();
		String result = gson.toJson(testObj);
		System.out.println(result);

		String zookeeper = getValueByKey(result, "zookeeper");
		System.out.println(zookeeper);

		String brokers = getValueByKey(result, "brokers");
		System.out.println(brokers);

	}

	public static String getValueByKey1(String jsonStr, String key) {
		Pattern zookeeperPattern = Pattern.compile(key + "\":\"(\\d+\\.\\d+\\.\\d+\\.\\d+:\\d+)\"");
		Matcher matcher = zookeeperPattern.matcher(jsonStr);
		while (matcher.find()) {
			return matcher.group(1);
		}
		return null;
	}
	
	public static String getValueByKey(String jsonStr, String key) {
		Pattern zookeeperPattern = Pattern.compile(key + "\":\"(.*?)\"");
		Matcher matcher = zookeeperPattern.matcher(jsonStr);
		if (matcher.find()) {
			return matcher.group(1);
		}
		return null;
	}
}

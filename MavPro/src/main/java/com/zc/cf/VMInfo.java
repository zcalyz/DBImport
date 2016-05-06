package com.zc.cf;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class VMInfo {
	public static Map<String, String> vmMap = new HashMap<String, String>();
	
	static{
		vmMap.put("url", "http://10.10.102.35:4567/servers/");
	}
	
	public static void add(Map<String, String> map){
		Set<Entry<String, String>> entrySet = map.entrySet();
		for(Entry<String, String> entry : entrySet){
			vmMap.put(entry.getKey(), entry.getValue());
		}
	}
	
	public static String getValue(String key){
		return vmMap.get(key);
	}
}

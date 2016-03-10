package com.service.Import.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public class ConfigUtil {
	public static Map<Object, Object> configMap;
	
	static{
		configMap = new HashMap<Object, Object>();
		ClassLoader classLoader = ConfigUtil.class.getClassLoader();
		InputStream stream = classLoader.getResourceAsStream("Config.properties");
		Properties properties = new Properties();
		
		try {
			properties.load(stream);
			Set<Entry<Object, Object>> set = properties.entrySet();
			for(Entry<Object, Object> entry : set){
				configMap.put(entry.getKey(), entry.getValue());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static String getValue(String key){
		return (String) configMap.get(key);
	}

}

package com.json;

import java.util.ArrayList;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Demo_1 {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		String jstr = "{'name':'zc','age':'12'}";
		Gson gson = new Gson();
		Map fromJsonMap = gson.fromJson(jstr, Map.class);
		System.out.println(fromJsonMap.get("age"));
		
		ArrayList list = new ArrayList();
		list.add("name");
		list.add("123");
		list.add(fromJsonMap);
		
		String json = gson.toJson(list);
		System.out.println(json);
		
		//处理json array
		String jarray = "[{'name':'kevin','age':25},{'name':'cissy','age':24}]";
		JsonParser parser = new JsonParser();
		JsonArray jsonArray = parser.parse(jarray).getAsJsonArray();
		for(JsonElement element : jsonArray){
			fromJsonMap																																																																																																																																																																																																		.putAll(gson.fromJson(element, Map.class));
		}
		
		String jobject = "{'obj':'{'name':'zz','age','12'}'}";
	
		JsonObject jsonObject = parser.parse(jobject).getAsJsonObject();
		System.out.println(jsonObject);
	}
}

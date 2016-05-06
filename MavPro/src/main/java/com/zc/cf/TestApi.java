package com.zc.cf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import com.google.gson.Gson;

public class TestApi {
	public static void main(String[] args) {
/*		String str = "{Ip:10.10.101.27,Id:c55c772d-e892-476a-96ee-9a9f7e526b6e,Port:}";
		Gson gson = new Gson();
		Map map = gson.fromJson(str, Map.class);
		System.out.println(map.get("Ip"));*/
		String planId = "mysql-1211pro_m-m-m-new2";
		
		int index = planId.indexOf('_');
    	String hostType = planId.substring(0, index);
		String url = VMInfo.getValue("url") + hostType;
		
		CloseableHttpClient client = HttpClientBuilder.create().build();
		HttpPost httpPost = new HttpPost(url);
//		HttpGet httpPost = new HttpGet(url);

		try {
			CloseableHttpResponse response = client.execute(httpPost);
			InputStream in = response.getEntity().getContent();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
			String str;
			while((str = bufferedReader.readLine()) != null){
				Gson gson = new Gson();
				System.out.println(str);
				VMInfo.add(gson.fromJson(str, Map.class));
			}
			
			System.out.println(VMInfo.getValue("ip") + " " + VMInfo.getValue("port") + " " + VMInfo.getValue("id"));
			
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

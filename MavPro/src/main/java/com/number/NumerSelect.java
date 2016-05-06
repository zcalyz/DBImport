package com.number;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumerSelect {
	private static final int BASE = 360;
	
	private Map<Integer, Integer> resultMap = new HashMap<Integer, Integer>();
	
	private ArrayList<String> remain = new ArrayList<String>();
	
	private int number;
	
	private int price;
	
	public static void main(String[] args) {
		NumerSelect obj = new NumerSelect();
		obj.selectNumber("/home/zc/number.txt");
	}
	
	public void selectNumber(String fileName){
		BufferedReader reader = readFile(fileName);
		String line;
		try {
			while((line = reader.readLine()) != null){
				if(isBeginWithNum(line)){
					getPrice1(line);
					if(price < BASE && price != -1){
						resultMap.put(number, price);
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		writeResult("/home/zc/resultNumber");
	}
	
	public BufferedReader  readFile(String fileName){
		BufferedReader reader = null;
		try {
			FileInputStream in = new FileInputStream(fileName);
			reader = new BufferedReader(new InputStreamReader(in));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reader;
	}
	
	public boolean isBeginWithNum(String str){
		Pattern pattern = Pattern.compile("^(\\d+)(.*)");
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}
	// use regular expression
	public void getPrice1(String str){
		Pattern pattern = Pattern.compile("[0-9]{3,}");
		Matcher matcher = pattern.matcher(str);
		if(matcher.find()){
			number = Integer.valueOf(matcher.group());
		}
		if(matcher.find()){
			price = Integer.valueOf(matcher.group());
		}else{
			price = -1;
			remain.add(str);
		}
	}
	// do not user regular expression
	public int getPrice(String str){
		String[] strs = str.split("-");
		String pri = null;
		if(strs.length >= 3){
			String price = strs[2];
			int index = price.indexOf("元");
			if(index > 0){
				pri = price.substring(0, index);
				return Integer.valueOf(pri);
			}else{
				remain.add(str);
				return -1;
			}	
		}else{
			remain.add(str);
			return -1;
		}
	}
	
	public int getNumber(String str){
		String[] strs = str.split("-");
		String num = strs[0];
		return Integer.valueOf(num);
	}
	
	public void writeResult(String fileName){
		System.out.println("result " + resultMap.size());
		System.out.println("remain " + remain.size());

		FileOutputStream out = null;
		PrintWriter printWriter = null;
		try {
			if(resultMap.size() > 0){
				out = new FileOutputStream(fileName);
				printWriter = new PrintWriter(out);
				Set<Entry<Integer, Integer>> sets = resultMap.entrySet();
				for(Entry<Integer, Integer> entry : sets){
					printWriter.write(entry.getKey() + "   "  + entry.getValue() + "\n");
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			printWriter.close();
		}
	}
}

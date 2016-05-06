package com.zc.regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo {
	public static void main(String[] args) {
/*		Pattern pattern = Pattern.compile("^[\\d].*[\\d]$");
		Matcher matcher = pattern.matcher("23123-12213");
		
		Pattern p2 = Pattern.compile("^3.*3");
		Matcher matcher2 = p2.matcher("3123sah23b1b");
		
		Pattern p3 = Pattern.compile("(a)([\\s])(b)");
		Matcher matcher3 = p3.matcher("a b");
		while(matcher3.find()){
			System.out.println(matcher3.group(3));
		}
		String email="--zc@123.com++kk@163.cn";
		Pattern p4 = Pattern.compile("(\\w+)@\\w+\\.(com|cn)");
		Matcher matcher4 = p4.matcher(email);
		while(matcher4.find()){
			System.out.println(matcher4.group(1));
		}*/
	
		String mothodIdentfier = "com.zc.ddction.ddd.select()";
		Pattern pm1 = Pattern.compile("(public|protected|private)*\\s*(.+)\\.\\w+\\.\\w+\\(");
		Matcher ma = pm1.matcher(mothodIdentfier);
		while(ma.find()){
			System.out.println(ma.group(2));
		}		
		
	}
}

package com.dbImport.action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.dbImport.config.DataSourceConfig;
import com.dbImport.util.DBConnector;

@Controller
public class UploadAction {

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public @ResponseBody String upload(@RequestParam("db_file.sql") MultipartFile file) {
		
		saveSqlFile(file);		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file.getName()));
			StringBuilder builder = new StringBuilder();

			String str = reader.readLine();
			while (str != null) {
				if (isSql(str)){
					builder.append(str+" ");
				}
				str = reader.readLine();
			}
			String tempStrs = builder.toString();
			tempStrs = tempStrs.substring(0, tempStrs.lastIndexOf(";"));
			String[] strArr = tempStrs.split(";");
			DBConnector dbc = new DBConnector(DataSourceConfig.getMySqlDataSource());
			for (String sqlStr : strArr) {
				if(sqlStr!=null && sqlStr!=" "){
					dbc.execute(sqlStr);
				}
			}
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		removeSqlFile(file.getName());
		return "import success!";
	}

	public void saveSqlFile(MultipartFile file) {
		String str = null;
		if (!file.isEmpty()) {
			byte[] bytes = null;
			try {
				bytes = file.getBytes();
				str = new String(bytes);
				String fileName = file.getName();

				FileWriter fileWriter = new FileWriter(fileName);
				fileWriter.write(str);
				fileWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static boolean isSql(String str){
		
		str=rmSpace(str);
		if (!str.startsWith("#") && !str.startsWith("/*") && !str.startsWith("-") && !str.startsWith("\n") 
				&& !str.startsWith("﻿-") && str!="" && !str.endsWith("*/;")){
			return true;
		}
		return false;
	}
	
	public static String rmSpace(String s){
	    for(int i=0;i<s.length();i++){
	            if(s.charAt(i)!=' '){
                    s=s.substring(i,s.length());
	                    break;
	             }
	    }
	    return s;
	}
	
	public void removeSqlFile(String fileName) {
		File file = new File(fileName);
		if (file.exists()) {
			System.out.println("delete");
			file.delete();
		}
	}
}

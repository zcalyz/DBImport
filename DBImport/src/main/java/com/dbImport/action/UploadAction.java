package com.dbImport.action;

import java.io.FileWriter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadAction {
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public @ResponseBody String upload(@RequestParam("db_file.sql") MultipartFile file) {
		savaSqlFile(file);

		String[] cmdImport = getCommand(file.getName());
		Process process = null;
		try {
			process = Runtime.getRuntime().exec(cmdImport);

			int waitFor = process.waitFor();
			System.out.println("success");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		removeSqlFile(file.getName());
		return "import success!";
	}

	public void savaSqlFile(MultipartFile file) {
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				String str = new String(bytes);
				String fileName = file.getName();

				FileWriter fileWriter = new FileWriter(fileName);
				fileWriter.write(str);
				// System.out.println(str);
				fileWriter.close();
			} catch (Exception e) {
				System.out.println("file is empty");
			}
		}
	}
	//ip、user、password需要通过接口得到
	public String[] getCommand(String fileName) {
		String[] cmdImport = new String[] { "/bin/bash", "-c", "" };

		String ip = "10.10.105.112";
		
		String port = "3306";

		String user = "cf_user_f079d13a";

		String password = "cf_passwd_f079d13a";
		
		StringBuilder cmdBuilder = new StringBuilder();
		//use shell mysql cmd:   mysql -h10.10.105.112 -uroot -p123456 -P3306 < db_file.sql
		cmdBuilder.append("mysql -h").append(ip).append(" -u").append(user)
				.append(" -p").append(password)
				.append(" -P").append(port).append(" < ")
				.append(fileName);
		
		System.out.println(cmdBuilder.toString());
		cmdImport[2] = cmdBuilder.toString();

		return cmdImport;
	}
	
	public void removeSqlFile(String fileName){
		String cmd = "rm " + fileName;
		Process process;
		try {
			process = Runtime.getRuntime().exec(cmd);
			process.waitFor();
			System.out.println("remove success");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}

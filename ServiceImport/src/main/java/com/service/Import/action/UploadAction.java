package com.service.Import.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.service.Import.config.ConfigUtil;


@Controller
public class UploadAction {

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String upload(@RequestParam("service_file") MultipartFile file) {
		System.out.println(file);
		if(file == null || file.getSize() == 0){
			return "fail";
		}
		saveSqlFile(file);
		return "success";
	}

	public void saveSqlFile(MultipartFile file) {
		if (!file.isEmpty()) {
			byte[] bytes = null;
			FileOutputStream out = null;
			try {
				bytes = file.getBytes();		
				String fileName = file.getOriginalFilename();
				String absolutePath = ConfigUtil.getValue("path") + fileName;
				File targetFile = new File(absolutePath);
				if(targetFile.exists()){
					//删除之前同名文件
					targetFile.delete();
				}
				out = new FileOutputStream(targetFile);			
				out.write(bytes);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
/*	public boolean uploadFile(String ip, MultipartFile file ){
		FTPClient ftpClient = new FTPClient();
		ftpClient.setControlEncoding("UTF-8");
		
		try {
			ftpClient.connect(ip, 21);
			ftpClient.login(ConfigUtil.getValue("username"), ConfigUtil.getValue("password"));
			ftpClient.setFileTransferMode(ftpClient.BINARY_FILE_TYPE);
			ftpClient.enterLocalActiveMode();
			
			ftpClient.setFileType(ftpClient.BINARY_FILE_TYPE);
			
			String path = ConfigUtil.getValue("path");
			boolean res = ftpClient.changeWorkingDirectory("/home/zc/uploadZip/");
			String filename = file.getOriginalFilename();
			InputStream in = file.getInputStream();
			
			boolean res1 = ftpClient.storeFile(filename, in);
			ftpClient.logout();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(ftpClient.isConnected()){
				try {
					ftpClient.disconnect();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}	
		return true;
	}*/
}

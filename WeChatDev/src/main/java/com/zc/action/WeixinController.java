package com.zc.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zc.util.SignUtil;

@Controller
@RequestMapping("/wechat")
public class WeixinController {
	
	@RequestMapping(value="/core", method=RequestMethod.GET)
	public void get(HttpServletRequest request, HttpServletResponse response){
		String signature = request.getParameter("signature");
		
		String timestamp = request.getParameter("timestamp");
		
		String nonce = request.getParameter("nonce");
		
		System.out.println(response);
		
		String echostr = request.getParameter("echostr");
		
		PrintWriter out = null;  
        try {  
            out = response.getWriter();  
            // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，否则接入失败  
            if (SignUtil.checkSignature(signature, timestamp, nonce)) {  
                out.print(echostr);  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            out.close();  
            out = null;  
        }  
	}
}

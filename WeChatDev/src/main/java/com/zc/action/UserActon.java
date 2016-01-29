package com.zc.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/user")
public class UserActon {
	
	@RequestMapping("/show")
	public String show(HttpServletRequest request,Model model){
		String name = request.getParameter("name");
//		User user = userService.selectByName(name);
		
	/*	List list = userService.listAll();
		
		model.addAttribute("users", list);*/
/*		System.out.println(list);*/
		return "show";
	}
	
	@RequestMapping("aaa")
	public @ResponseBody String aa(HttpServletRequest request,Model model){
		return "aaa";
	}
}

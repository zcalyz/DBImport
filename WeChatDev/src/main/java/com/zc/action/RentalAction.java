package com.zc.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("rental")
public class RentalAction {
	
	public String getMovieInfo(HttpServletRequest request,Model mode,String namel){
		
		return "movieInfo";
	}
}

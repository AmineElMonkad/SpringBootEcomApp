package org.ecom.sec;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {
	
	@RequestMapping(value="/login")
	public String login() {
		System.out.println("hohohoh");
		return "login";
	}
	
	@RequestMapping(value="/logout")
	public String logout(HttpServletRequest request) {
		
		System.out.println("hohohoh");
		return "login";
	}
	
}

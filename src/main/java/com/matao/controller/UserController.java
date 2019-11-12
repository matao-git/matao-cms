package com.matao.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("user")
public class UserController {
	//httpxxxx://user/hello
	@RequestMapping(value="hello",method=RequestMethod.GET)
	public String tet(HttpServletRequest request) {
		request.setAttribute("info", "来啦，老弟");
		return "user/test";
	}
}

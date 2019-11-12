package com.matao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 
    * @ClassName: AdminController
    * @Description: 管理员控制类
    * @author 马涛
    * @date 2019年11月12日
    *
 */
@Controller
@RequestMapping("admin")
public class AdminController {
	
	@RequestMapping("index")
	public String index() {
		return "admin/index";
	}
	

}	

package com.matao.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.matao.common.MsgResult;
import com.matao.entity.User;
import com.matao.service.UserService;

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
	@Autowired
	private UserService service;
	 
	@RequestMapping("index")
	public String index() {
		return "admin/index";
	}
	
	@RequestMapping("articles")
	public String articles() {
		return "/admin/article/list";
	}
	
	@RequestMapping("users")
	public String users(@RequestParam(defaultValue="") String name,
			HttpServletRequest request,
			@RequestParam(defaultValue="1") Integer page) {
			 PageInfo<User> userPage = service.getPageList(name,page);
			request.setAttribute("info",userPage);
			request.setAttribute("name",name);
		return "/admin/user/list";
	}
	
	@ResponseBody
	@RequestMapping("lockuser")
	public MsgResult lock(Integer userId,int status) {
		
		if(status !=0 && status!=1) {
			return new MsgResult(2, "参数无效", null);
		}
		
		User user =service.getUserById(userId);
		
		if(user==null) {
			return new MsgResult(2, "该用户不存在", null);
		}
		
		if(user.getLocked()==status) {
			return new MsgResult(2, "无需做该操作", null);
		}
		
		int result = service.updateStatus(userId,status);
		if(result>0) {
			return new MsgResult(1,"恭喜您，处理成功",null);
		}else{
			return new MsgResult(2,"非常抱歉，处理失败，请与管理员联系！",null);
		}
	}
}	

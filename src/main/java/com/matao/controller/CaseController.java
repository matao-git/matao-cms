package com.matao.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.matao.StringUtils;
import com.matao.common.ConstantClass;
import com.matao.common.MsgResult;
import com.matao.entity.Case;
import com.matao.entity.User;
import com.matao.service.CaseService;


/**
 *  收藏
 * @author 马涛
 *
 */
@Controller
@RequestMapping("collect")
public class CaseController {
	
	@Autowired
	CaseService collectService;
	
	/**
	 * 
	 * @param request
	 * @param page
	 * @return
	 */
	@RequestMapping("list")
	public String list(HttpServletRequest request, 
			@RequestParam(defaultValue="1") int page) {
		
		User loginUser=(User)request.getSession().getAttribute(ConstantClass.USER_KEY);
		
		
		PageInfo info = collectService.list(loginUser.getId(), page);
		request.setAttribute("info", info);
		return "user/collect/list";
		
		
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	@GetMapping("add")
	public String add(HttpServletRequest request) {
		request.setAttribute("collect", new Case());
		return "user/collect/add";	 
	}
	
	
	@GetMapping("update")
	public String update(HttpServletRequest request,int id) {
		request.setAttribute("collect", collectService.get(id));
		return "user/collect/update";	 
	}
	
	
	@RequestMapping("delete")
	@ResponseBody
	public MsgResult delete(HttpServletRequest request,int id) {
		int result = collectService.delete(id);
		if(result<1)
			return new MsgResult(2,"删除失败",null);
		
		return new MsgResult(1,"删除失败",null);
		
	}
	
	/**
	 * 
	 * @param request
	 * @param collect
	 * @param result
	 * @return
	 */
	@PostMapping("update")
	public String update(HttpServletRequest request,
			@Valid @ModelAttribute("collect") Case collect,
			BindingResult result
			) {
		
		if(!StringUtils.isHttpUrl(collect.getUrl())) {
			result.rejectValue("url", "不是合法的url", "不是合法的url");
		}
		
		// 有错误 还在原来的页面
		if(result.hasErrors()) {
			//request.setAttribute("collect", collect);
			return "user/collect/update";	
		}
		
		collectService.update(collect);
		
		// 没有错误跳转到列表页面
		return "redirect:list";
	}
	
	
	
	

}

package com.matao.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.matao.entity.Article;
import com.matao.entity.Category;
import com.matao.entity.Channel;
import com.matao.service.ArticleService;
import com.matao.service.CategoryService;
import com.matao.service.ChannelService;
import com.matao.service.LineService;
import com.matao.entity.Line;

@Controller
public class IndexController {
	/**
	 * 注入频道
	 */
	@Autowired
	private ChannelService channelService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	LineService linkService;
	
	/**
	 * 
	 * @param request
	 * @param chnId  频道id
	 * @param page  文章页码
	 * @return
	 */
	@RequestMapping("channel")
	public String channel(HttpServletRequest request,
			@RequestParam(defaultValue = "1")int  chnId,
			@RequestParam(defaultValue = "0")int  categoryId,
			@RequestParam(defaultValue = "1")int  page
			) {
		// 回传参数数值
		request.setAttribute("chnId", chnId);
		request.setAttribute("categoryId", categoryId);
		
		//获取所有频道
		List<Channel> channels =channelService.list();
			request.setAttribute("channels", channels);
		//获取改频道下的所有分类
			List<Category> categories = categoryService.listByChannelId(chnId);
			
			request.setAttribute("categories", categories);
			
			PageInfo<Article> articles = articleService.listByCat(chnId,categoryId,page);
			request.setAttribute("articles", articles);
		
		
		return "channelindex";
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = { "index", "/" })
	public String index(HttpServletRequest request,HttpServletResponse reponse, @RequestParam(defaultValue = "1") int page) {

		Cookie cookie = new Cookie("ckey", "cValue");
		//cookie.setDomain("/");
		cookie.setMaxAge(2000);
		cookie.setComment("test22");
		cookie.setMaxAge(1000);
		cookie.setVersion(18);
		reponse.addCookie(cookie);
		
		reponse.addCookie(cookie);
		
		cookie = new Cookie("ckey1", "cValue1");
		//cookie.setDomain("/");
		cookie.setMaxAge(2000);
		cookie.setComment("test");
		cookie.setMaxAge(1000);
		cookie.setVersion(16);
		reponse.addCookie(cookie);
		
		//获取所有的频道
		List<Channel> channels = channelService.list();
		request.setAttribute("channels", channels);
		
		PageInfo<Article> hotList = articleService.hotList(page);
		
		List<Article> newArticles = articleService.getNewArticles(5);
		
		// 获取最新图片文章
		List<Article> imgArticles = articleService.getImgArticles(10);
		
		// 友情链接
		   PageInfo<Line> info=  linkService.list(1);
		   List<Line> linkList =  info.getList();
		
		request.setAttribute("hotList", hotList);
		request.setAttribute("newArticles", newArticles);
		
		request.setAttribute("imgArticles", imgArticles);
		
		

		request.setAttribute("linkList", linkList);
		
		//
		
		return "index";
	}

}
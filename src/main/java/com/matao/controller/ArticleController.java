package com.matao.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.matao.common.CmsAssert;
import com.matao.common.MsgResult;
import com.matao.entity.Article;
import com.matao.entity.Category;
import com.matao.service.ArticleService;
import com.matao.service.CategoryService;
import com.matao.entity.Comment;
import com.matao.entity.Image;
import com.matao.entity.TypeEnum;


@RequestMapping("article")
@Controller
public class ArticleController {
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private CategoryService catService; 
	
	@RequestMapping("showdetail")
	public String showDetail(HttpServletRequest request,Integer id) {
		Article article = articleService.getById(id); 
		CmsAssert.AssertTrueHtml(article!=null, "文章不存在");
		
		
		request.setAttribute("article",article);
		if(article.getArticleType()==TypeEnum.HTML)
			return "article/detail";
		else {
			Gson gson = new Gson();
			// 文章内容转换成集合对象
			List<Image> imgs = gson.fromJson(article.getContent(), List.class);
			article.setImgList(imgs);
			System.out.println(" article is "  + article);
			return "article/detailimg";
		}
	}
	
	//getCategoryByChannel",{chnId:channelId},"
		//		+ "
		@RequestMapping("getCategoryByChannel")
		@ResponseBody
		public MsgResult getCategoryByChannel(int chnId) {
			//List<Category> categories =  
			List<Category> categories = catService.listByChannelId(chnId);
			return new MsgResult(1, "",  categories);
			
		}
		
		@RequestMapping("commentlist")
		//@ResponseBody
		public String commentlist(HttpServletRequest request, int id,
				@RequestParam(defaultValue="1") int page) {
			
			PageInfo<Comment> pageComment =  articleService.commentlist(id,page);
			request.setAttribute("pageComment", pageComment);
			return "article/comments";
			//return new MsgResult(1,"获取成功",pageComment);
			
		}
}

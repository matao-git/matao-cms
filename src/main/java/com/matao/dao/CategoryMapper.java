package com.matao.dao;

import java.util.List;

import com.matao.entity.Category;

public interface CategoryMapper {
	/**
	 * 
	    * @Title: listByChannelId
	    * @Description:获取分类
	    * @param @param chnId
	    * @param @return    参数
	    * @return List<Category>    返回类型
	    * @throws
	 */
	List<Category> listByChannelId(int chnId);

}

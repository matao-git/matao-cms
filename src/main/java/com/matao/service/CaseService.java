package com.matao.service;


import com.github.pagehelper.PageInfo;
import com.matao.entity.Case;

/**
 *  收藏
 * @author	马涛
 *
 */
public interface CaseService {

	/**
	 * 
	 * @param collect
	 * @return
	 */
	int add(Case collect);
	/**
	 * 
	 * @param page
	 * @return
	 */
	PageInfo list(int userId,int page);
	/**
	 * 
	 * @param id
	 * @return
	 */
	int delete(int id);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	Case get(int id);
	
	/**
	 * 
	 * @param collect
	 * @return
	 */
	int update( Case collect);

}

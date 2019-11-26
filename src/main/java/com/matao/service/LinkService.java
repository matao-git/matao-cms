package com.matao.service;


import com.github.pagehelper.PageInfo;
import com.matao.entity.Link;

/**
 * 
 * @author 马涛
 *
 */
public interface LinkService {

	int add(Link link);
	PageInfo list(int page);
	int delete(int id);
	Link get(int id);
	int update( Link link);

}

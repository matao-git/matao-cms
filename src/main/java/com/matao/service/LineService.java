package com.matao.service;


import com.github.pagehelper.PageInfo;
import com.matao.entity.Line;

/**
 * 
 * @author 马涛
 *
 */
public interface LineService {

	int add(Line link);
	PageInfo list(int page);
	int delete(int id);
	Line get(int id);
	int update( Line link);

}

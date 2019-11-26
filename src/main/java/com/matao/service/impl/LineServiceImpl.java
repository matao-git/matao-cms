package com.matao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.matao.dao.LineMapper;
import com.matao.entity.Line;
import com.matao.service.LineService;

/**
 * 
 * @author 马涛
 *
 */
@Service
public class LineServiceImpl  implements LineService{
	
	@Autowired
	LineMapper linkMapper;

	@Override
	public int add(Line link) {
		// TODO Auto-generated method stub
		return linkMapper.add(link);
		
	}

	@Override
	public PageInfo list(int page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page,10);
		
		return new PageInfo<Line>(linkMapper.list());
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return linkMapper.delete(id);
	}

	@Override
	public Line get(int id) {
		// TODO Auto-generated method stub
		return linkMapper.get(id);
	}

	@Override
	public int update(Line link) {
		// TODO Auto-generated method stub
		return linkMapper.update(link);
		
	}

}

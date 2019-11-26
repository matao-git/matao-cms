package com.matao.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.matao.dao.CaseMapper;
import com.matao.entity.Case;
import com.matao.service.CaseService;

/**
 * 
 *
 */
@Service
public class CaseServiceImpl  implements CaseService{
	
	@Autowired
	CaseMapper collectMapper;

	@Override
	public int add(Case collect) {
		// TODO Auto-generated method stub
		return collectMapper.add(collect);
		
	}

	@Override
	public PageInfo list(int userId,int page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page,10);
		return new PageInfo<Case>(collectMapper.list(userId));
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return collectMapper.delete(id);
	}

	@Override
	public Case get(int id) {
		// TODO Auto-generated method stub
		return collectMapper.get(id);
	}

	@Override
	public int update(Case collect) {
		// TODO Auto-generated method stub
		return collectMapper.update(collect);
		
	}

}

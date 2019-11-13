package com.matao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.matao.common.ConstantClass;
import com.matao.dao.UserMapper;
import com.matao.entity.User;
import com.matao.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper mapper;
	
	@Override
	public PageInfo<User> getPageList(String name, Integer page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, ConstantClass.PAGE_SIZE);
		
		return  new PageInfo<User>(mapper.list(name));
	}

	@Override
	public User getUserById(Integer userId) {
		// TODO Auto-generated method stub
		return mapper.getUserById(userId);
	}

	@Override
	public int updateStatus(Integer userId, int status) {
		// TODO Auto-generated method stub
		return mapper.updateStatus(userId,status);
	}
}

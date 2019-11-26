package com.matao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.matao.common.CmsAssert;
import com.matao.common.ConstantClass;
import com.matao.common.Md5;
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
	public User getById(Integer userId) {
		// TODO Auto-generated method stub
		return mapper.getById(userId);
	}

	@Override
	public int updateStatus(Integer userId, int status) {
		// TODO Auto-generated method stub
		return mapper.updateStatus(userId,status);
	}
	@Override
	public User findByName(String username) {
		// TODO Auto-generated method stub
		return mapper.findByUserName(username);
	}

	@Override
	public int register(User user) {
		
		// TODO Auto-generated method stub
		//用户名是否存在
		User existUser  = findByName(user.getUsername());
		CmsAssert.AssertTrue(existUser==null,"该用户名已经存在");
				
		//加盐
		user.setPassword(Md5.password(user.getPassword(),
				user.getUsername().substring(0, 2)));
		return mapper.add(user);
		
	}

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		
		User loginUser = findByName(user.getUsername());
		if(loginUser==null)
			return null;
		
		// 计算加盐加密后的密码
		String pwdSaltMd5 = Md5.password(user.getPassword(),
				user.getUsername().substring(0, 2));
		
		//数据库中密码与用户输入的密码一致  则登录成功
		if(pwdSaltMd5.equals(loginUser.getPassword())) {
			return loginUser;
		}else {
			//登录失败
			return null;
		}
		
		
	}

}

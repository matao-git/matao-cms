package com.matao.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.matao.entity.User;

public interface UserMapper {

	List<User> list(String name);

	User getById(Integer userId);
	
	@Update("update cms_user set locked=${status} where id =${userId}")
	int updateStatus(@Param("userId")Integer userId, @Param("status")int status);

	@Select("SELECT * FROM cms_user "
			+ " WHERE username = #{value} limit 1 ")
	User findByUserName(String username);

	int add(User user);
}

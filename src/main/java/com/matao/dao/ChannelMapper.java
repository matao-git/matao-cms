package com.matao.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.matao.entity.Channel;

public interface ChannelMapper {
	@Select("select * from cms_channel order by id")
	List<Channel> list();

}

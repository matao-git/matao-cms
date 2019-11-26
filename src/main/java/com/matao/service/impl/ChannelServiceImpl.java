package com.matao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matao.dao.ChannelMapper;
import com.matao.entity.Channel;
import com.matao.service.ChannelService;
@Service
public class ChannelServiceImpl implements ChannelService{
	@Autowired
	private ChannelMapper channelMapper;

	@Override
	public List<Channel> list() {
		// TODO Auto-generated method stub
		return channelMapper.list();
	}

}

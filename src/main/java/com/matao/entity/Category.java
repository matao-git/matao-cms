package com.matao.entity;

import java.io.Serializable;

/**
 * 
    * @ClassName: Category
    * @Description: 分类
    * @author 马涛
    *
 */
public class Category implements Serializable{

	
	    /**
	    * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	    */
	    
	private static final long serialVersionUID = -3502778290090174604L;
	
	private Integer id;
	
	private String name;
	
	/**
	 * 频道id
	 */
	private int channelId;
	/**
	 * 频道
	 * 
	 */
	private Channel channel;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getChannelId() {
		return channelId;
	}
	public void setChannelId(int channelId) {
		this.channelId = channelId;
	}
	public Channel getChannel() {
		return channel;
	}
	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	
	
}

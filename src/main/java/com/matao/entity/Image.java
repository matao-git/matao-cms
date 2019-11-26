package com.matao.entity;

/**
 * 
    * @ClassName: Image
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author 马涛
    *
 */
public class Image {
	
	private String url;
	private String desc;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	@Override
	public String toString() {
		return "Image [url=" + url + ", desc=" + desc + "]";
	}
	
	

}

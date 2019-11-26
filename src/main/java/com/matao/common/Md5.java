package com.matao.common;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * 
    * @ClassName: Md5
    * @Description: 加密的工具类
    * @author 马涛
    *
 */
public class Md5 {

	public static String password(String password, String salt) {
		// TODO Auto-generated method stub
		return DigestUtils.md5Hex(password + "::::" +  salt);
	}

	
		
}

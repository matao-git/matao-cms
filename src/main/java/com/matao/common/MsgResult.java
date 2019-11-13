package com.matao.common;

import java.io.Serializable;
/**
 * 
    * @ClassName: MsgResult
    * @Description: 用于前后端交互的协议
    * @author 马涛
    * @date 2019年11月13日
    *
 */
public class MsgResult implements Serializable{

	
	    /**
	    * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	    */
	    
	private static final long serialVersionUID = 4011967275863409121L;
	
	int result;
	String errorMsg;
	Object data;
	
	public MsgResult(int result, String errorMsg, Object data) {
		super();
		this.result = result;
		this.errorMsg = errorMsg;
		this.data = data;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	
}

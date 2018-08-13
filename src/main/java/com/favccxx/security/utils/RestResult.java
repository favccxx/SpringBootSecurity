package com.favccxx.security.utils;

import com.alibaba.fastjson.JSON;

public class RestResult<T> {
	
	public static final int SUCCESS = 0;
	public static final String SUCCESS_MSG = "操作成功";
	
	int statusCode;
	
	String message;
	
	T data;

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	
	
	 public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	

	public static <T> String success(T data){
		 RestResult<T> res = new RestResult<T>();
		 res.setStatusCode(SUCCESS);
		 res.setData(data);
		 res.setMessage(SUCCESS_MSG);
		 return JSON.toJSONString(res);
	}
	
	
	

}

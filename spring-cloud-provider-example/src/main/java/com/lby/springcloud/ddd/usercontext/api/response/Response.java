package com.lby.springcloud.ddd.usercontext.api.response;
import java.io.Serializable;

public class Response<T> implements Serializable {
	private static final long serialVersionUID = -1L;
	
	protected String code;
	protected String msg;
	protected T data;

	public Response() {
	}

	public String getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	public T getData() {
		return data;
	}

	public Response<T> setCode(String code) {
		this.code = code;
		return this;
	}

	public Response<T> setMsg(String msg) {
		this.msg = msg;
		return this;
	}

	public Response<T> setData(T data) {
		this.data = data;
		return this;
	}
}

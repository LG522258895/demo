package org.cloudnote.core.result;

import java.io.Serializable;

public class Result implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer code = null;
	private String msg = null;
	private Object data = null;

	public Result() {
		this.code = Integer.valueOf(0);
	}

	public Integer getCode() {
		return this.code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return this.msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return this.data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}

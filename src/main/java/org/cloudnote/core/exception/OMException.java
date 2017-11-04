package org.cloudnote.core.exception;

public class OMException extends Exception{
	private static final long serialVersionUID = -1336221687352611794L;
	private Integer errCode = null;

	public OMException(Integer errCode) {
		this.errCode = errCode;
	}

	public OMException(Integer errCode, String errMsg) {
		super(errMsg);
		this.errCode = errCode;
	}

	public OMException(Integer errCode, Throwable e) {
		super(e);
		this.errCode = errCode;
	}

	public OMException(Integer errCode, String errMsg, Throwable e) {
		super(errMsg, e);
		this.errCode = errCode;
	}

	public Integer getErrCode() {
		return this.errCode;
	}
}

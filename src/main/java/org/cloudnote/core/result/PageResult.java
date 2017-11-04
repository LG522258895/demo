package org.cloudnote.core.result;

public class PageResult extends Result{
	private static final long serialVersionUID = -4405717977161333863L;
	private Integer total = null;

	public Integer getTotal() {
		return this.total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}
}

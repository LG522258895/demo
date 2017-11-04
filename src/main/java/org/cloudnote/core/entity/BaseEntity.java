package org.cloudnote.core.entity;

public class BaseEntity extends BaseIDEntity {
	private static final long serialVersionUID = 1L;
	private Long createId = null;
	private Long createTime = null;
	private Long modifyId = null;
	private Long modifyTime = null;

	public Long getCreateId() {
		return createId;
	}

	public void setCreateId(Long createId) {
		this.createId = createId;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public Long getModifyId() {
		return modifyId;
	}

	public void setModifyId(Long modifyId) {
		this.modifyId = modifyId;
	}

	public Long getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Long modifyTime) {
		this.modifyTime = modifyTime;
	}

}

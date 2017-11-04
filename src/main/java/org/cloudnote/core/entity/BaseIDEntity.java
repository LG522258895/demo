package org.cloudnote.core.entity;

import java.io.Serializable;

public class BaseIDEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;

	private String batisKey = null;

	private String domain = null;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBatisKey() {
		return batisKey;
	}

	public void setBatisKey(String batisKey) {
		this.batisKey = batisKey;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

}

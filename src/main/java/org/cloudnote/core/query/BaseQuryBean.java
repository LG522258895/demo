package org.cloudnote.core.query;

import java.util.List;

import org.cloudnote.core.entity.BaseIDEntity;

public class BaseQuryBean<T extends BaseIDEntity> {
	private String batisKey = null;
    private Long id = null;
    private String name = null;
    private String title = null;
    private Class<? extends BaseIDEntity> entityCls = null;
    private T dto = null;
    private String domain = null;
    private List<Long> idList = null;
    private Long parentId = null;
    private Integer dataStts = null;
    private Integer busStts = null;
    private Long countryId = null;

    public String getBatisKey() {
        return batisKey;
    }

    public void setBatisKey(String batisKey) {
        this.batisKey = batisKey;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Class<? extends BaseIDEntity> getEntityCls() {
        return entityCls;
    }

    public void setEntityCls(Class<? extends BaseIDEntity> entityCls) {
        this.entityCls = entityCls;
    }

    public T getDto() {
        return dto;
    }

    public void setDto(T dto) {
        this.dto = dto;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public List<Long> getIdList() {
        return idList;
    }

    public void setIdList(List<Long> idList) {
        this.idList = idList;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getDataStts() {
        return dataStts;
    }

    public void setDataStts(Integer dataStts) {
        this.dataStts = dataStts;
    }

    public Integer getBusStts() {
        return busStts;
    }

    public void setBusStts(Integer busStts) {
        this.busStts = busStts;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }
}

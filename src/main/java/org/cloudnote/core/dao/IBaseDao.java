package org.cloudnote.core.dao;

import java.util.List;

import org.cloudnote.core.entity.BaseIDEntity;
import org.cloudnote.core.exception.OMException;
import org.cloudnote.core.query.BaseQueryPage;
import org.cloudnote.core.query.BaseQuryBean;
import org.cloudnote.core.result.PageResult;

public interface IBaseDao<T extends BaseIDEntity> {
	public void saveEntity(T arg0) throws OMException;

    public void saveEntity(List<T> arg0) throws OMException;

    public void modifyEntity(T arg0) throws OMException;

    public void modifyEntity(List<T> arg0) throws OMException;

    public void modifyEntity(BaseQuryBean<T> arg0) throws OMException;

    public void deleteEntity(T arg0) throws OMException;

    public void deleteEntity(List<T> arg0) throws OMException;

    public void deleteEntity(BaseQuryBean<T> arg0) throws OMException;

    public T findOne(BaseQuryBean<T> arg0) throws OMException;

    public List<T> findList(BaseQuryBean<T> arg0) throws OMException;

    public Integer findCount(BaseQuryBean<T> arg0) throws OMException;

    public List<T> findList(BaseQueryPage<T> arg0) throws OMException;

    public PageResult findPage(BaseQueryPage<T> arg0) throws OMException;

    public boolean exsitRecord(BaseQuryBean<T> arg0) throws OMException;
}

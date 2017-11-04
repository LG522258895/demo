package org.cloudnote.core.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.cloudnote.core.dao.IBaseDao;
import org.cloudnote.core.entity.BaseIDEntity;
import org.cloudnote.core.exception.OMException;
import org.cloudnote.core.query.BaseQueryPage;
import org.cloudnote.core.query.BaseQuryBean;
import org.cloudnote.core.result.PageResult;
import org.cloudnote.util.system.ObjectUtils;
import org.cloudnote.util.system.StringUtils;
import org.mybatis.spring.support.SqlSessionDaoSupport;

public class BaseDaoImpl<T extends BaseIDEntity> extends SqlSessionDaoSupport implements IBaseDao<T> {
	public static final String INSERT = "insert";
	public static final String MOIDFY = "modify";
	public static final String DELETE = "delete";
	public static final String SELECT_LIST = "selectList";
	public static final String FIND_ONE = "findOne";
	public static final String FIND_COUNT = "findCount";
	public static final String LIST = "list";
	public static final String LIST_SUFFIX = "Count";
	public static final String FIND_LONG_COUNT = "findLongCount";
	public static final String EXSIT_ID = "exsitId";
	public static final String MODIFY_CONDITIONS = "modifyConditions";

	private String concatSpace(Class<? extends BaseIDEntity> class1, String key) throws OMException {
		if (ObjectUtils.isNull(class1)) {
			throw new OMException(Integer.valueOf(2000));
		} else {
			String entityName = class1.getSimpleName();
			return entityName.concat(".").concat(key);
		}
	}

	public void saveEntity(T entity) throws OMException {
		String batisKey = entity.getBatisKey();
		batisKey = this.concatSpace(entity.getClass(), StringUtils.isEmpty(batisKey) ? INSERT : batisKey);
		this.getSqlSession().insert(batisKey, entity);
	}

	public void saveEntity(List<T> entity) throws OMException {
		Iterator arg1 = entity.iterator();

		while (arg1.hasNext()) {
			T t = (T) arg1.next();
			this.saveEntity(t);
		}

	}

	public void modifyEntity(T entity) throws OMException {
		String batisKey = entity.getBatisKey();
		batisKey = this.concatSpace(entity.getClass(), StringUtils.isEmpty(batisKey) ? MOIDFY : batisKey);
		this.getSqlSession().update(batisKey, entity);
	}

	public void modifyEntity(List<T> entity) throws OMException {
		Iterator arg1 = entity.iterator();

		while (arg1.hasNext()) {
			T t = (T) arg1.next();
			this.saveEntity(t);
		}

	}

	public void deleteEntity(T entity) throws OMException {
		String batisKey = entity.getBatisKey();
		batisKey = this.concatSpace(entity.getClass(), StringUtils.isEmpty(batisKey) ? DELETE : batisKey);
		this.getSqlSession().delete(batisKey, entity);
	}

	public void deleteEntity(List<T> entity) throws OMException {
		Iterator arg1 = entity.iterator();

		while (arg1.hasNext()) {
			T t = (T) arg1.next();
			this.saveEntity(t);
		}

	}

	public void deleteEntity(BaseQuryBean<T> queryBean) throws OMException {
		String batisKey = queryBean.getBatisKey();
		batisKey = this.concatSpace(queryBean.getEntityCls(), StringUtils.isEmpty(batisKey) ? DELETE : batisKey);
		this.getSqlSession().delete(batisKey, queryBean);
	}

	public List<T> findList(BaseQuryBean<T> queryBean) throws OMException {
		String batisKey = queryBean.getBatisKey();
		batisKey = this.concatSpace(queryBean.getEntityCls(), StringUtils.isEmpty(batisKey) ? SELECT_LIST : batisKey);
		return this.getSqlSession().selectList(batisKey, queryBean);
	}

	public T findOne(BaseQuryBean<T> queryBean) throws OMException {
		String batisKey = queryBean.getBatisKey();
		batisKey = this.concatSpace(queryBean.getEntityCls(), StringUtils.isEmpty(batisKey) ? FIND_ONE : batisKey);
		return (T) this.getSqlSession().selectOne(batisKey, queryBean);
	}

	public Integer findCount(BaseQuryBean<T> queryBean) throws OMException {
		String batisKey = queryBean.getBatisKey();
		batisKey = this.concatSpace(queryBean.getEntityCls(), StringUtils.isEmpty(batisKey) ? FIND_COUNT : batisKey);
		Object obj = this.getSqlSession().selectOne(batisKey, queryBean);
		return Integer.valueOf(ObjectUtils.isNull(obj) ? 0 : Integer.valueOf(String.valueOf(obj)).intValue());
	}

	public Long findLongCount(BaseQueryPage<T> queryBean) throws OMException {
		String batisKey = queryBean.getBatisKey();
		batisKey = this.concatSpace(queryBean.getEntityCls(),
				StringUtils.isEmpty(batisKey) ? FIND_LONG_COUNT : batisKey);
		Object obj = this.getSqlSession().selectOne(batisKey, queryBean);
		return Long.valueOf(ObjectUtils.isNull(obj) ? 0L : Long.valueOf(String.valueOf(obj)).longValue());
	}

	public List<T> findList(BaseQueryPage<T> queryBean) throws OMException {
		String batisKey = queryBean.getBatisKey();
		batisKey = this.concatSpace(queryBean.getEntityCls(), StringUtils.isEmpty(batisKey) ? LIST : batisKey);
		return this.getSqlSession().selectList(batisKey, queryBean);
	}

	public PageResult findPage(BaseQueryPage<T> queryBean) throws OMException {
		PageResult result = new PageResult();
		String batisKey = queryBean.getBatisKey();
		batisKey = StringUtils.isEmpty(batisKey) ? "list" : batisKey;
		queryBean.setBatisKey(batisKey.concat("Count"));
		Integer totalCount = this.findCount(queryBean);
		result.setTotal(totalCount);
		if (totalCount.intValue() > 0) {
			queryBean.setBatisKey(batisKey);
			result.setData(this.findList(queryBean));
		} else if (null == this.findList(queryBean)) {
			result.setData(new ArrayList());
			result.setTotal(Integer.valueOf(0));
		}

		return result;
	}

	public boolean exsitRecord(BaseQuryBean<T> queryBean) throws OMException {
		String batisKey = queryBean.getBatisKey();
		batisKey = StringUtils.isEmpty(batisKey) ? "exsitId" : batisKey;
		Integer totalCount = this.findCount(queryBean);
		return totalCount.intValue() > 0;
	}

	public void modifyEntity(BaseQuryBean<T> queryBean) throws OMException {
		String batisKey = queryBean.getBatisKey();
		batisKey = StringUtils.isEmpty(batisKey) ? "modifyConditions" : batisKey;
		this.getSqlSession().update(batisKey, queryBean);
	}
}

package com.company.project.persist.common.prototype;

import java.util.List;
import java.util.Map;

import com.company.project.model.pager.PagerModel;

/**
 * 通用Dao接口设计
 * @author RanJi
 * @since 2013-12-13 pm
 * @version jdk1.6.21
 */
public interface IGenericDao<T> {
	//-- 1. 常规方法
	public int save(T entity,Class<T> typeObject);									//-- 返回保存实体后的主键（或许有用得着的时候，不是吗？）
	public int update(T entity,Class<T> typeObject);									//-- 返回更新后实体的主键（或许有用得着的时候，不是吗？）
	public void deleteByID(int oid,Class<T> typeObject);
	public void deleteAll(Class<T> typeObject);
	public T findByID(int oid,Class<T> typeObject);
	public List<T> findAll(Class<T> typeObject);
	
	//-- 2. 分页查询方法
	public PagerModel<T> findPaginated(Class<T> typeObject);
	public PagerModel<T> findPaginated(Map<String,Object> params, String methodName, String methodNameForNumOfItems,Class<T> typeObject);
	
}

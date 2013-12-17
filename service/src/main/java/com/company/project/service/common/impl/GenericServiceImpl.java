package com.company.project.service.common.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.company.project.model.pager.PagerModel;
import com.company.project.persist.common.prototype.IGenericDao;
import com.company.project.service.common.prototype.IGenericService;

public class GenericServiceImpl<T> implements IGenericService<T> {
	
	@Autowired
	protected IGenericDao<T> dao;
		
	@Override
	public int save(T entity, Class<T> typeObject) {
		return dao.save(entity, typeObject);
	}

	@Override
	public int update(T entity, Class<T> typeObject) {
		return dao.update(entity, typeObject);
	}

	@Override
	public void deleteByID(int oid, Class<T> typeObject) {
		dao.deleteByID(oid, typeObject);
	}

	@Override
	public void deleteAll(Class<T> typeObject) {
		dao.deleteAll(typeObject);
	}

	@Override
	public T findByID(int oid, Class<T> typeObject) {
		return dao.findByID(oid, typeObject);
	}

	@Override
	public List<T> findAll(Class<T> typeObject) {
		return dao.findAll(typeObject);
	}

	@Override
	public PagerModel<T> findPaginated(Class<T> typeObject) {
		return dao.findPaginated(typeObject);
	}

	@Override
	public PagerModel<T> findPaginated(Map<String, Object> params,
			String methodName, String methodNameForNumOfItems,
			Class<T> typeObject) {
		return dao.findPaginated(params, methodName, methodNameForNumOfItems, typeObject);
	}

}

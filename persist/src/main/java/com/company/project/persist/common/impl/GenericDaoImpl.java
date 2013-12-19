package com.company.project.persist.common.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.ranji.system.SystemContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.company.project.model.pager.PagerModel;
import com.company.project.persist.common.prototype.IGenericDao;

public  class GenericDaoImpl<T> implements IGenericDao<T> {
	
	@Autowired
	protected SqlSessionFactory sqlSessionFactory;
	
	@Override
	public int save(T entity,Class<T> typeObject) {
		SqlSession s = sqlSessionFactory.openSession();
		int entityID = s.insert(typeObject.getPackage().getName()+".save"+typeObject.getSimpleName(),entity);
		s.close();	
		return entityID;
	}
	
	@Override
	public int update(T entity,Class<T> typeObject) {
		SqlSession s = sqlSessionFactory.openSession();
		int entityID = s.update(typeObject.getPackage().getName()+".update"+typeObject.getSimpleName(),entity);
		s.close();	
		return entityID;
	}

	@Override
	public void deleteByID(int oid,Class<T> typeObject) {
		SqlSession s = sqlSessionFactory.openSession();
		s.delete(typeObject.getPackage().getName()+".delete"+typeObject.getSimpleName(), oid);
		s.close();
	}

	@Override
	public void deleteAll(Class<T> typeObject) {
		SqlSession s = sqlSessionFactory.openSession();
		s.delete(typeObject.getPackage().getName()+".deleteAll"+typeObject.getSimpleName()+"s");
		s.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findByID(int oid,Class<T> typeObject) {
		SqlSession s = sqlSessionFactory.openSession();
		T entity = (T)s.selectOne(typeObject.getPackage().getName()+".find"+typeObject.getSimpleName(), oid);
		s.close();
		return entity;
	}

	@Override
	public List<T> findAll(Class<T> typeObject) {
		SqlSession s = sqlSessionFactory.openSession();
		List<T> entitys = s.selectList(typeObject.getPackage().getName()+".findAll"+typeObject.getSimpleName()+"s");
		return entitys;
	}

	@Override
	public PagerModel<T> findPaginated(Map<String, Object> params,String methodName, String methodNameForNumOfItems, Class<T> typeObject) {
		//-- 1.不管传或不传参数都会追加至少两个分页参数
		if(params==null || params.size()==0) 
			params = new HashMap<String,Object>();
		params.put("offset", SystemContext.getOffset());
		params.put("limit", SystemContext.getPageSize());
		
		SqlSession s = sqlSessionFactory.openSession();
		PagerModel<T> pm = new PagerModel<T>();
		
		int total = getNumberOfItems(typeObject.getPackage().getName()+methodNameForNumOfItems,params);
		List<T> entitys = s.selectList(typeObject.getPackage().getName()+methodName,params);
		
	
		pm.setTotal(total);
		pm.setData(entitys);
		
		return pm;
	}
   /**
    * 获取总的条目数
    * @return
    */
	private int getNumberOfItems(String methodNameForNumOfItems,Map<String, Object> params){
		SqlSession s = sqlSessionFactory.openSession();
		int count = (Integer)s.selectOne(methodNameForNumOfItems, params);
		s.close();
		return count;
	}

	@Override
	public PagerModel<T> findPaginated(T paramsValueObject, Class<T> typeObject) {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("pvo", paramsValueObject);
		return findPaginated(params, ".findPaginated"+typeObject.getSimpleName()+"s", ".getNumberOf"+typeObject.getSimpleName()+"Items",typeObject);
	}
	
	
}

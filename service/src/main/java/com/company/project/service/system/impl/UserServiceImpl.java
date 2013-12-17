package com.company.project.service.system.impl;

import org.springframework.stereotype.Service;

import com.company.project.model.system.User;
import com.company.project.service.common.impl.GenericServiceImpl;
import com.company.project.service.system.prototype.IUserService;

/**
 * 用户服务接口实现
 * @author 纪冉
 */
@Service
public class UserServiceImpl extends GenericServiceImpl<User> implements IUserService {
	
	//-- 默认即有dao属性
	//-- 若有自己定义的业务接口方法，那么就调用dao属性去实现，或者综合实现
	//-- 若需添加新的业务方法，则最有可能调用的为:
	//-- dao.findPaginated(params, methodName, methodNameForNumOfItems, typeObject)方法
	
}

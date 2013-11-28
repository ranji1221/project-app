package com.company.project.restlet.application;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

import com.company.project.restlet.hello.HelloResource;

/**
 * Ŀǰûʲô���ã����Ժ���ʱ������չ����
 * @author RanJi
 */
public class BaseApplication extends Application{
	
	@Override
	public Restlet createInboundRoot() {
		
		Router router = new Router(getContext());
		
		router.attach("/hello",HelloResource.class);
		
		return router;
	}
}

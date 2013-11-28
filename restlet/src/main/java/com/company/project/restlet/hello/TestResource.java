package com.company.project.restlet.hello;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("/test/{id}")
@Scope("prototype")
public class TestResource extends ServerResource{
	
	@Get("xml")
	public String xmlData(){
		String value = (String)getRequestAttributes().get("id");
		System.out.println("����Web�ͻ���ת���ID��ֵ��id="+value);
		return "<user><id>1</id><name>zhangsan</name></user>";
	}
}

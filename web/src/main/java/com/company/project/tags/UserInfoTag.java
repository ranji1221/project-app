package com.company.project.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.company.project.model.system.User;

public class UserInfoTag extends TagSupport {
	private static final long serialVersionUID = -8046332149632408872L;
	
	//-- getter和setter属性值
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public int doStartTag() throws JspException {
		try{
			JspWriter out = this.pageContext.getOut();
			if(user == null){
				out.println("No User Found...");
				return SKIP_BODY;
			}
			out.println("<table>");
			out.println("<tr>");
		}catch(Exception e){
				throw new JspException(e.getMessage());
		}
		return SKIP_BODY;
	}
	
	@Override
	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}
	
	@Override
	public void release() {
		super.release();
		this.user = null;
	}
}

package com.nankai.app.util;

import javax.websocket.Session;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class loginInterceptor extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation arg0) throws Exception {
		//����������Ƿ��Ѿ���¼
				Integer username = (Integer) ServletActionContext.getRequest().getSession().getAttribute("username");
			    if(username==null)
			    {
			    	ServletActionContext.getRequest().setAttribute("msg", "����δ��¼�����ȵ�¼");
			    	return "fail";
			    }
			    else
			    {
			    	return arg0.invoke();
			    }
	}

}

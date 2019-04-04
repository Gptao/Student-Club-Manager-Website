package com.nankai.app.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.nankai.app.domain.Department;
import com.nankai.app.service.DepartmentService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class DepartmentAction extends ActionSupport implements ModelDriven<Department>,ServletResponseAware,ServletRequestAware{
	Department dpt = new Department();
	//springøÚº‹œ¬Ã·π©Service
	private DepartmentService departmentService;
	private HttpServletResponse response;
	private HttpServletRequest request;
	
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
		
		
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		
	}
	public void setDpt(Department dpt) {
		this.dpt = dpt;
	}
	public Department getDpt() {
		return dpt;
	}
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	public String findAll()
	{
		List<Department> dptList = departmentService.findAll();
		ServletActionContext.getRequest().getSession().setAttribute("DepartmentList", dptList);
		return SUCCESS;
	}
	public String findAllForActivityUpdate()
	{
		List<Department> dptList = departmentService.findAll();
		ServletActionContext.getRequest().getSession().setAttribute("DepartmentList", dptList);
		return "activity";
	}
	public String findAllForRegister()
	{
		List<Department> dptList = departmentService.findAll();
		ServletActionContext.getRequest().getSession().setAttribute("DepartmentList", dptList);
		return "registerjsp";
	}
	public String findAllForUpdateMember()
	{
		List<Department> dptList = departmentService.findAll();
		ServletActionContext.getRequest().getSession().setAttribute("DepartmentList", dptList);
		return "updateMember";
	}
	
	@Override
	public Department getModel() {
		return dpt;
	}
	
	
	public void findAllForAndroid(){
		response.setCharacterEncoding("utf-8");
		List<Department> dptList = departmentService.findAll();
		JSONArray array=new JSONArray();
		for(Department dpt:dptList){
			JSONObject obj=new JSONObject();
			obj.put("departmentId", dpt.getDepartmentId());
			obj.put("departmentOrg", dpt.getOrganization().getOrganizationName());
			obj.put("departmentName", dpt.getDepartmentName());
			array.add(obj);
		}
		System.out.println(array.toString());
		try {
			PrintWriter out = response.getWriter();
			out.print(array.toString());
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

package com.nankai.app.action;

import org.apache.struts2.ServletActionContext;

import com.nankai.app.domain.Organization;
import com.nankai.app.service.OrgService;
import com.nankai.app.vo.OrgPage;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class OrgAction extends ActionSupport implements ModelDriven<Organization>{
	private Organization org = new Organization();
	//分页需要使用的参数
	private int currentPage=1;
	private int pageSize=9;
	//spring框架下提供Service
	private OrgService orgService;
	//只需要写set方法
	public void setOrgService(OrgService orgService) {
		this.orgService = orgService;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	//输出显示数据库Organization表中所有的记录
	public String showAll()
	{
		OrgPage orgPage = orgService.findAll(currentPage, pageSize);
		ServletActionContext.getRequest().setAttribute("orgPage", orgPage);
		return SUCCESS;
	}
	public String showAllForIntro()
	{
		OrgPage orgPage = orgService.findAll(currentPage, pageSize);
		ServletActionContext.getRequest().setAttribute("orgPage", orgPage);
		return "intro";
	}
	//向数据库Organization表添加记录
	public String add()
	{
		orgService.add(org);
		return SUCCESS;
	}
	public String showAllForMaterialAdd()
	{
		OrgPage orgPage = orgService.findAll(currentPage, pageSize);
		ServletActionContext.getRequest().setAttribute("orgPage", orgPage);
		return "materialAdd";
	}
	public String showAllForMaterialUpdate()
	{
		OrgPage orgPage = orgService.findAll(currentPage, pageSize);
		ServletActionContext.getRequest().setAttribute("orgPage", orgPage);
		return "materialUpdate";
	}
	
	
	@Override
	public Organization getModel() {
		return org;
	}
	
}

package com.nankai.app.action;

import org.apache.struts2.ServletActionContext;

import com.nankai.app.domain.Organization;
import com.nankai.app.service.OrgService;
import com.nankai.app.vo.OrgPage;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class OrgAction extends ActionSupport implements ModelDriven<Organization>{
	private Organization org = new Organization();
	//��ҳ��Ҫʹ�õĲ���
	private int currentPage=1;
	private int pageSize=9;
	//spring������ṩService
	private OrgService orgService;
	//ֻ��Ҫдset����
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
	//�����ʾ���ݿ�Organization�������еļ�¼
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
	//�����ݿ�Organization����Ӽ�¼
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

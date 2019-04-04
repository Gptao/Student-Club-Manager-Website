package com.nankai.app.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.nankai.app.domain.Material;
import com.nankai.app.service.MaterialService;
import com.nankai.app.service.impl.MaterialServiceImpl;
import com.nankai.app.util.HibernateUtil;
import com.nankai.app.vo.MaterialPage;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class MaterialAction extends ActionSupport implements ModelDriven<Material>,ServletResponseAware,ServletRequestAware{
	private int currentPage=1;
	private int pageSize=5;
	private Material material = new Material();
	private MaterialService materialService;
	
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
	
	public void setMaterialService(MaterialService materialService) {
		this.materialService = materialService;
	}
	public String add(){
		materialService.add(material);
		return "material_search";
	}
	public String update(){
		materialService.update(material);
		return "material_search";
	}
	public String findById(){
		Material material1 = materialService.findMaterialById(material.getMaterialId());
		ServletActionContext.getRequest().setAttribute("material", material1);
		return "findById";
	}
	public String delete(){
		//materialService
		materialService.delete(material.getMaterialId());
		return "material_search";
	}
	public void deleteForAndroid(){
		response.setCharacterEncoding("utf-8");
		String materialId=(String) request.getParameter("materialId");
		materialService.delete(Integer.parseInt(materialId)-2);
		try {
			PrintWriter out = response.getWriter();
			out.print("success");
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public String search(){
		
		MaterialPage materialPage = materialService.findAll(currentPage, pageSize);
		ServletActionContext.getRequest().setAttribute("materialPage", materialPage);
		return SUCCESS;
		
	}
	public void searchForAndroid(){
		response.setCharacterEncoding("utf-8");
		List<Material> list=materialService.findAllForAndroid();
		JSONArray array=new JSONArray();
		for(Material material:list){
			JSONObject obj=new JSONObject();
			obj.put("materialId",material.getMaterialId());
			obj.put("materialName",material.getMaterialName());
			obj.put("materialCount",material.getMaterialAmount());
			obj.put("materialOrg",material.getOrganization().getOrganizationName());
			obj.put("materialExtra",material.getMaterialRemarks());
			array.add(obj);
		}
		try {
			PrintWriter out = response.getWriter();
			out.print(array.toString());
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public Material getModel() {
		// TODO Auto-generated method stub
		return material;
	}

}

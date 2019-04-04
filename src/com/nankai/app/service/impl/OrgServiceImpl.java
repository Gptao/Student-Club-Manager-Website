package com.nankai.app.service.impl;

import java.util.List;

import com.nankai.app.dao.OrgDao;
import com.nankai.app.domain.Organization;
import com.nankai.app.service.OrgService;
import com.nankai.app.vo.OrgPage;
import com.sun.org.apache.xpath.internal.operations.Or;

public class OrgServiceImpl implements OrgService{

	private OrgDao orgDao;//spring框架下，只要写set方法
	public void setOrgDao(OrgDao orgDao) {
		this.orgDao = orgDao;
	}

	@Override
	public void add(Organization org) {
		orgDao.add(org);		
	}

	@Override
	public void update(Organization org) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int oid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public OrgPage findAll(int currentPage, int pageSize) {
		//根据传入的参数（当前页、页规模），返回OrgPage对象，保存有分页信息:所有记录、当前页、页size、总记录数量、总页数
		OrgPage orgPage = new OrgPage();
		List<Organization> list = orgDao.findAll(currentPage, pageSize);
		orgPage.setDataList(list);
		orgPage.setCurrentPage(currentPage);
		orgPage.setPageSize(pageSize);
		int totalCount = orgDao.findTotalCount();
		orgPage.setTotalCount(totalCount);
		orgPage.setTotalPage(totalCount % pageSize ==0?totalCount/pageSize:totalCount/pageSize+1);
		return orgPage;
	}

	@Override
	public Organization findById(int id) {
		return orgDao.findById(id);
	}

}

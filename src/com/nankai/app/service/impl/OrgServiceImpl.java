package com.nankai.app.service.impl;

import java.util.List;

import com.nankai.app.dao.OrgDao;
import com.nankai.app.domain.Organization;
import com.nankai.app.service.OrgService;
import com.nankai.app.vo.OrgPage;
import com.sun.org.apache.xpath.internal.operations.Or;

public class OrgServiceImpl implements OrgService{

	private OrgDao orgDao;//spring����£�ֻҪдset����
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
		//���ݴ���Ĳ�������ǰҳ��ҳ��ģ��������OrgPage���󣬱����з�ҳ��Ϣ:���м�¼����ǰҳ��ҳsize���ܼ�¼��������ҳ��
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

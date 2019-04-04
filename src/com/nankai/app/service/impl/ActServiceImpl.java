package com.nankai.app.service.impl;

import java.util.List;

import com.nankai.app.dao.ActDao;
import com.nankai.app.domain.Activity;
import com.nankai.app.domain.Organization;
import com.nankai.app.service.ActService;
import com.nankai.app.vo.ActPage;
import com.nankai.app.vo.OrgPage;

public class ActServiceImpl implements ActService{
	private ActDao actDao;
	public void setActDao(ActDao actDao) {
		this.actDao = actDao;
	}

	@Override
	public void add(Activity act) {
		actDao.add(act);
	}

	@Override
	public void update(Activity act) {
		actDao.update(act);
	}

	@Override
	public void delete(Activity act) {
		actDao.delete(act);		
	}

	@Override
	public ActPage findAll(int currentPage, int pageSize) {
		//���ݴ���Ĳ�������ǰҳ��ҳ��ģ��������OrgPage���󣬱����з�ҳ��Ϣ:���м�¼����ǰҳ��ҳsize���ܼ�¼��������ҳ��
		ActPage actPage = new ActPage();
		List<Activity> list = actDao.findAll(currentPage, pageSize);
		actPage.setDataList(list);
		actPage.setCurrentPage(currentPage);
		actPage.setPageSize(pageSize);
		int totalCount = actDao.findTotalCount();
		actPage.setTotalCount(totalCount);
		actPage.setTotalPage(totalCount % pageSize ==0?totalCount/pageSize:totalCount/pageSize+1);
		return actPage;
	}
	
	@Override
	public List<Activity> findAllForList() {
		return actDao.findAllForList();
	}
	@Override
	public Activity findMemberByID(int aid) {
		return actDao.findActivityById(aid);
	}

}

package com.nankai.app.service;

import java.util.List;

import com.nankai.app.domain.Activity;
import com.nankai.app.vo.ActPage;

public interface ActService {
	//����
	public void add(Activity act);
	//�޸�
	public void update(Activity act);
	//ɾ��
	public void delete(Activity act);
	//��ѯȫ��,���ط�ҳ���������
	public ActPage findAll(int currentPage,int pageSize);
	//��ѯȫ��,-----����ҳ
	public List<Activity> findAllForList();
	//ͨ��ID��ѯ
	public Activity findMemberByID(int aid);
}

package com.nankai.app.dao;

import java.util.List;

import com.nankai.app.domain.Activity;


public interface ActDao {
	//����
		public void add(Activity act);
		//�޸�
		public void update(Activity act);
		//ɾ��
		public void delete(Activity act);
		//��ѯȫ��---��ҳ
		public List<Activity> findAll(int currentPage,int pageSize);
		
		//��ѯȫ��---����ҳ
		public List<Activity> findAllForList();
		//����idȥ��ѯͼ��
		/*public Organization findBookById(int oid);
		public int findTotalCount();*/
		public int findTotalCount();
		public Activity findActivityById(int aid);
}

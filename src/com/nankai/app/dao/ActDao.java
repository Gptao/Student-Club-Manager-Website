package com.nankai.app.dao;

import java.util.List;

import com.nankai.app.domain.Activity;


public interface ActDao {
	//增加
		public void add(Activity act);
		//修改
		public void update(Activity act);
		//删除
		public void delete(Activity act);
		//查询全部---分页
		public List<Activity> findAll(int currentPage,int pageSize);
		
		//查询全部---不分页
		public List<Activity> findAllForList();
		//根据id去查询图书
		/*public Organization findBookById(int oid);
		public int findTotalCount();*/
		public int findTotalCount();
		public Activity findActivityById(int aid);
}

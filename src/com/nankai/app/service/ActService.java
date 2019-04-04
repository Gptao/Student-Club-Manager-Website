package com.nankai.app.service;

import java.util.List;

import com.nankai.app.domain.Activity;
import com.nankai.app.vo.ActPage;

public interface ActService {
	//增加
	public void add(Activity act);
	//修改
	public void update(Activity act);
	//删除
	public void delete(Activity act);
	//查询全部,返回分页所需的数据
	public ActPage findAll(int currentPage,int pageSize);
	//查询全部,-----不分页
	public List<Activity> findAllForList();
	//通过ID查询
	public Activity findMemberByID(int aid);
}

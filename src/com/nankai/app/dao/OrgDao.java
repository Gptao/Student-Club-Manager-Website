package com.nankai.app.dao;

import java.util.List;

import com.nankai.app.domain.Organization;

public interface OrgDao {
	//增加
	public void add(Organization org);
	//修改
	public void update(Organization org);
	//删除
	public void delete(int  oid);
	//查询全部
	public List<Organization> findAll(int currentPage,int pageSize);
	//根据id去查询社团
/*	public Organization findBookById(int oid);
	public int findTotalCount();*/
	public int findTotalCount();
	public Organization findById(int id);
}

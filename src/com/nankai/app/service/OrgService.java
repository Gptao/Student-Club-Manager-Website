package com.nankai.app.service;

import com.nankai.app.domain.Organization;
import com.nankai.app.vo.OrgPage;

public interface OrgService {
	//增加
	public void add(Organization org);
	//修改
	public void update(Organization org);
	//删除
	public void delete(int oid);
	//查询全部,返回分页所需的数据
	public OrgPage findAll(int currentPage,int pageSize);
	public Organization findById(int id);
}

package com.nankai.app.dao;

import java.util.List;

import com.nankai.app.domain.Organization;

public interface OrgDao {
	//����
	public void add(Organization org);
	//�޸�
	public void update(Organization org);
	//ɾ��
	public void delete(int  oid);
	//��ѯȫ��
	public List<Organization> findAll(int currentPage,int pageSize);
	//����idȥ��ѯ����
/*	public Organization findBookById(int oid);
	public int findTotalCount();*/
	public int findTotalCount();
	public Organization findById(int id);
}

package com.nankai.app.service;

import com.nankai.app.domain.Organization;
import com.nankai.app.vo.OrgPage;

public interface OrgService {
	//����
	public void add(Organization org);
	//�޸�
	public void update(Organization org);
	//ɾ��
	public void delete(int oid);
	//��ѯȫ��,���ط�ҳ���������
	public OrgPage findAll(int currentPage,int pageSize);
	public Organization findById(int id);
}

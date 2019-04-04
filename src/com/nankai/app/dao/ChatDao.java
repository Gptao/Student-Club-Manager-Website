package com.nankai.app.dao;

import java.util.List;

import com.nankai.app.domain.Chatroom;

public interface ChatDao {
	//����
	public void add(Chatroom chat);
	//�޸�
	public void update(Chatroom chat);
	//ɾ��
	public void delete(Chatroom chat);
	//��ѯȫ��(��ҳ)
	public List<Chatroom> findAll(int currentPage,int pageSize);
	//����ҳ
	public List<Chatroom> findAllForList();
	//����idȥ��ѯ����
	public int findTotalCount();
}

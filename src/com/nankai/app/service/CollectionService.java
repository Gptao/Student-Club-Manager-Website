package com.nankai.app.service;

import java.util.List;

import com.nankai.app.domain.Chatroom;
import com.nankai.app.domain.Collection;



public interface CollectionService {
	//����
	public void add(Collection collection);
	//�޸�
	public void update(Collection collection);
	//ɾ��
	public void delete(Collection collection);
	//��ѯȫ��
	public List<Collection> findAll();
	//�����ղ��߲�ѯ
	public List<Collection> findCollectionByUser(int userId);
	//���ݻ��ѯ
	public List<Collection> findCollectionByActivity(int activityId);
	public Collection findCollectionByUserAndActivity(int userId,int activityId);
}

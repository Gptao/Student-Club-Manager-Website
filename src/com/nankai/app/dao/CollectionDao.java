package com.nankai.app.dao;

import java.util.List;

import com.nankai.app.domain.Chatroom;
import com.nankai.app.domain.Collection;
import com.nankai.app.domain.Organization;

public interface CollectionDao {
	//����
	public void add(Collection collection);
	//�޸�
	public void update(Collection collection);
	//ɾ��
	public void delete(Collection collection);
	//��ѯȫ��
	public List<Collection> findAll();
	//�����ղ��߲�ѯ�����Ҹ��û��������ղؼ�¼��
	public List<Collection> findCollectionByUser(int userId);
	//���ݻ��ѯ
	public List<Collection> findCollectionByActivity(int activityId);
	//�����û���  �id��ѯ�ղؼ�¼
	public Collection findCollectionByUserAndActivity(int userId, int activityId);
}

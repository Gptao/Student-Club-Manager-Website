package com.nankai.app.service;

import java.util.List;

import com.nankai.app.domain.Chatroom;
import com.nankai.app.vo.ActPage;
import com.nankai.app.vo.ChatPage;



public interface ChatService {
	//����
	public void add(Chatroom chat);
	//�޸�
	public void update(Chatroom chat);
	//ɾ��
	public void delete(Chatroom chat);
	//��ѯȫ��,��������
	public List<Chatroom> findAllForList();
	//
	public ChatPage findAll(int currentPage,int pageSize);
	//ͨ��ID��ѯ
	/*public Activity findMemberByID(int aid);*/
}

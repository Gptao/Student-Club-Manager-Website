package com.nankai.app.service;

import java.util.List;

import com.nankai.app.domain.Chatroom;
import com.nankai.app.vo.ActPage;
import com.nankai.app.vo.ChatPage;



public interface ChatService {
	//增加
	public void add(Chatroom chat);
	//修改
	public void update(Chatroom chat);
	//删除
	public void delete(Chatroom chat);
	//查询全部,返回数据
	public List<Chatroom> findAllForList();
	//
	public ChatPage findAll(int currentPage,int pageSize);
	//通过ID查询
	/*public Activity findMemberByID(int aid);*/
}

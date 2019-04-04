package com.nankai.app.service.impl;

import java.util.List;

import com.nankai.app.dao.ChatDao;
import com.nankai.app.domain.Activity;
import com.nankai.app.domain.Chatroom;
import com.nankai.app.service.ChatService;
import com.nankai.app.vo.ActPage;
import com.nankai.app.vo.ChatPage;

public class ChatServiceImpl implements ChatService{

	private ChatDao chatDao;
	
	public void setChatDao(ChatDao chatDao) {
		this.chatDao = chatDao;
	}

	@Override
	public void add(Chatroom chat) {
		chatDao.add(chat);
	}

	@Override
	public void update(Chatroom chat) {
		chatDao.update(chat);
	}

	@Override
	public void delete(Chatroom chat) {
		chatDao.delete(chat);
	}

	@Override
	public List<Chatroom> findAllForList() {
		return chatDao.findAllForList();
	}
	@Override
	public ChatPage findAll(int currentPage, int pageSize) {
		//根据传入的参数（当前页、页规模），返回OrgPage对象，保存有分页信息:所有记录、当前页、页size、总记录数量、总页数
		ChatPage chatPage = new ChatPage();
		List<Chatroom> list = chatDao.findAll(currentPage, pageSize);
		chatPage.setDataList(list);
		chatPage.setCurrentPage(currentPage);
		chatPage.setPageSize(pageSize);
		int totalCount = chatDao.findTotalCount();
		chatPage.setTotalCount(totalCount);
		chatPage.setTotalPage(totalCount % pageSize ==0?totalCount/pageSize:totalCount/pageSize+1);
		return chatPage;
	}
}

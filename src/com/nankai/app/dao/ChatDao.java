package com.nankai.app.dao;

import java.util.List;

import com.nankai.app.domain.Chatroom;

public interface ChatDao {
	//增加
	public void add(Chatroom chat);
	//修改
	public void update(Chatroom chat);
	//删除
	public void delete(Chatroom chat);
	//查询全部(分页)
	public List<Chatroom> findAll(int currentPage,int pageSize);
	//不分页
	public List<Chatroom> findAllForList();
	//根据id去查询社团
	public int findTotalCount();
}

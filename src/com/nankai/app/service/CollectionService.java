package com.nankai.app.service;

import java.util.List;

import com.nankai.app.domain.Chatroom;
import com.nankai.app.domain.Collection;



public interface CollectionService {
	//增加
	public void add(Collection collection);
	//修改
	public void update(Collection collection);
	//删除
	public void delete(Collection collection);
	//查询全部
	public List<Collection> findAll();
	//根据收藏者查询
	public List<Collection> findCollectionByUser(int userId);
	//根据活动查询
	public List<Collection> findCollectionByActivity(int activityId);
	public Collection findCollectionByUserAndActivity(int userId,int activityId);
}

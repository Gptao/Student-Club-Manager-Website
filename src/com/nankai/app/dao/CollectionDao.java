package com.nankai.app.dao;

import java.util.List;

import com.nankai.app.domain.Chatroom;
import com.nankai.app.domain.Collection;
import com.nankai.app.domain.Organization;

public interface CollectionDao {
	//增加
	public void add(Collection collection);
	//修改
	public void update(Collection collection);
	//删除
	public void delete(Collection collection);
	//查询全部
	public List<Collection> findAll();
	//根据收藏者查询，查找该用户的所有收藏记录‘
	public List<Collection> findCollectionByUser(int userId);
	//根据活动查询
	public List<Collection> findCollectionByActivity(int activityId);
	//根据用户名  活动id查询收藏记录
	public Collection findCollectionByUserAndActivity(int userId, int activityId);
}

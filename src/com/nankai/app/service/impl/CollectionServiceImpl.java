package com.nankai.app.service.impl;

import java.util.List;

import com.nankai.app.dao.CollectionDao;
import com.nankai.app.domain.Collection;
import com.nankai.app.service.CollectionService;

public class CollectionServiceImpl implements CollectionService{

	private CollectionDao collectionDao;
	
	public void setCollectionDao(CollectionDao collectionDao) {
		this.collectionDao = collectionDao;
	}

	@Override
	public void add(Collection collection) {
		collectionDao.add(collection);
	}

	@Override
	public void update(Collection collection) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Collection collection) {
		collectionDao.delete(collection);
	}

	@Override
	public List<Collection> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Collection> findCollectionByUser(int userId) {
		return collectionDao.findCollectionByUser(userId);
	}

	@Override
	public List<Collection> findCollectionByActivity(int activityId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection findCollectionByUserAndActivity(int userId, int activityId) {
		return collectionDao.findCollectionByUserAndActivity(userId, activityId);
	}

}

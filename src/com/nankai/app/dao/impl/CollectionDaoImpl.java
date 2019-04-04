package com.nankai.app.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.nankai.app.dao.CollectionDao;
import com.nankai.app.domain.Collection;

public class CollectionDaoImpl extends HibernateDaoSupport implements CollectionDao{

	@Override
	public void add(Collection collection) {
		this.getHibernateTemplate().save(collection);
	}

	@Override
	public void update(Collection collection) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Collection collection) {
		this.getHibernateTemplate().delete(collection);
	}

	@Override
	public List<Collection> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Collection> findCollectionByUser(int userId) {
		return this.getHibernateTemplate().find("from Collection where userId = ?",userId);
	}

	@Override
	public List<Collection> findCollectionByActivity(int activityId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection findCollectionByUserAndActivity(int userId, int activityId) {
		List<Collection> list = this.getHibernateTemplate().find("from Collection where userId = ? and activityId = ?",userId,activityId);
		if(!list.isEmpty()){
			return list.get(0);
		}
		else
		{
			return null;
		}
	}

}

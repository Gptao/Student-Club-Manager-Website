package com.nankai.app.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.nankai.app.dao.ActDao;
import com.nankai.app.dao.OrgDao;
import com.nankai.app.domain.Activity;
import com.nankai.app.domain.Organization;

public class ActDaoImpl extends HibernateDaoSupport implements ActDao{

	@Override
	public void add(Activity act) {
		this.getHibernateTemplate().save(act);
	}

	@Override
	public void update(Activity act) {
		// 更新
		this.getHibernateTemplate().update(act);		
	}

	@Override
	public void delete(Activity act) {
		//删除
		this.getHibernateTemplate().delete(act);
	}

	@Override
	public List<Activity> findAll(final int currentPage, final int pageSize) {
		// 在spring框架下，使用HibernateTemplate从数据库查询所有满足条件的记录，返回结果列表
		//在回调中进行了一次查询（用当前页和页size对查询进行了限制）
		List list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException,SQLException {
				Query query  = session.createQuery("from Activity");
				query.setFirstResult((currentPage-1)*pageSize);
				query.setMaxResults(pageSize);
				List<Organization> list = query.list();
				return list;
			}
		});
		return list;
	}

	//查询全部  不分页
	@Override
	public List<Activity> findAllForList() {
		List list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException,SQLException {
				Query query  = session.createQuery("from Activity");
				List<Organization> list = query.list();
				return list;
			}
		});
		return list;
	}
	
	@Override
	public int findTotalCount() {
		// 查询数据库中总的记录数 
		Long count = (Long)this.getHibernateTemplate().find("select count(*) from Activity").listIterator().next();
		return count.intValue();
	}

	@Override
	public Activity findActivityById(int aid) {
		// 通过id寻找对象
		return this.getHibernateTemplate().get(Activity.class, aid);
	}
}

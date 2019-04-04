package com.nankai.app.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.nankai.app.dao.OrgDao;
import com.nankai.app.domain.Organization;

public class OrgDaoImpl extends HibernateDaoSupport implements OrgDao{

	@Override
	public void add(Organization org) {
		this.getHibernateTemplate().save(org);
	}

	@Override
	public void update(Organization org) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int oid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Organization> findAll(final int currentPage, final int pageSize) {
		// 在spring框架下，使用HibernateTemplate从数据库查询所有满足条件的记录，返回结果列表
		//在回调中进行了一次查询（用当前页和页size对查询进行了限制）
		List list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException,SQLException {
				Query query  = session.createQuery("from Organization");
				query.setFirstResult((currentPage-1)*pageSize);
				query.setMaxResults(pageSize);
				List<Organization> list = query.list();
				return list;
			}
		});
		return list;
	}

	@Override
	public int findTotalCount() {
		// 查询数据库中总的记录数 
		Long count = (Long)this.getHibernateTemplate().find("select count(*) from Organization").listIterator().next();
		return count.intValue();
	}

	@Override
	public Organization findById(int id) {
		List<Organization> list = this.getHibernateTemplate().find("from Organization where organizationId = ?",id);
		if(list.isEmpty()){
			return null;
		}
		else{
			return list.get(0);
		}
	}

}

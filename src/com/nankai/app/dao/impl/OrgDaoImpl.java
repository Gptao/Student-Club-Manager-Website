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
		// ��spring����£�ʹ��HibernateTemplate�����ݿ��ѯ�������������ļ�¼�����ؽ���б�
		//�ڻص��н�����һ�β�ѯ���õ�ǰҳ��ҳsize�Բ�ѯ���������ƣ�
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
		// ��ѯ���ݿ����ܵļ�¼�� 
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

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
		// ����
		this.getHibernateTemplate().update(act);		
	}

	@Override
	public void delete(Activity act) {
		//ɾ��
		this.getHibernateTemplate().delete(act);
	}

	@Override
	public List<Activity> findAll(final int currentPage, final int pageSize) {
		// ��spring����£�ʹ��HibernateTemplate�����ݿ��ѯ�������������ļ�¼�����ؽ���б�
		//�ڻص��н�����һ�β�ѯ���õ�ǰҳ��ҳsize�Բ�ѯ���������ƣ�
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

	//��ѯȫ��  ����ҳ
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
		// ��ѯ���ݿ����ܵļ�¼�� 
		Long count = (Long)this.getHibernateTemplate().find("select count(*) from Activity").listIterator().next();
		return count.intValue();
	}

	@Override
	public Activity findActivityById(int aid) {
		// ͨ��idѰ�Ҷ���
		return this.getHibernateTemplate().get(Activity.class, aid);
	}
}

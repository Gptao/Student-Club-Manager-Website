package com.nankai.app.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.nankai.app.dao.ChatDao;
import com.nankai.app.domain.Chatroom;
import com.nankai.app.domain.Organization;

public class ChatDaoImpl extends HibernateDaoSupport implements ChatDao{

	@Override
	public void add(Chatroom chat) {
		this.getHibernateTemplate().save(chat);
	}

	@Override
	public void update(Chatroom chat) {
		// ����
		this.getHibernateTemplate().update(chat);		
	}

	@Override
	public void delete(Chatroom chat) {
		//ɾ��
		this.getHibernateTemplate().delete(chat);
	}

	@Override
	public List<Chatroom> findAll(final int currentPage, final int pageSize) {
		// ��spring����£�ʹ��HibernateTemplate�����ݿ��ѯ�������������ļ�¼�����ؽ���б�
		//�ڻص��н�����һ�β�ѯ���õ�ǰҳ��ҳsize�Բ�ѯ���������ƣ�
		List list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException,SQLException {
				Query query  = session.createQuery("from Chatroom order by messageId desc");
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
	public List<Chatroom> findAllForList() {
		List list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException,SQLException {
				Query query  = session.createQuery("from Chatroom");
				List<Organization> list = query.list();
				return list;
			}
		});
		return list;
	}
	
	@Override
	public int findTotalCount() {
		// ��ѯ���ݿ����ܵļ�¼�� 
		Long count = (Long)this.getHibernateTemplate().find("select count(*) from Chatroom").listIterator().next();
		return count.intValue();
	}
}

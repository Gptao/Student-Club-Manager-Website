

package com.nankai.app.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.nankai.app.dao.MaterialDao;
import com.nankai.app.domain.Material;
import com.nankai.app.util.HibernateUtil;

public class MaterialDaoImpl extends HibernateDaoSupport implements MaterialDao{

	@Override
	public void add(Material material) {
		this.getHibernateTemplate().save(material);
	}

	@Override
	public void update(Material material) {
		this.getHibernateTemplate().update(material);
	}

	@Override
	public void delete(int materialId) {
		this.getHibernateTemplate().delete(this.findMaterialById(materialId));
	}

	@Override
	public List<Material> findAll(final int currentPage,final int pageSize) {
		List list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException,SQLException {
				Query query  = session.createQuery("from Material");
				query.setFirstResult((currentPage-1)*pageSize);
				query.setMaxResults(pageSize);
				List<Material> list = query.list();
				return list;
			}
		});
		return list;
	}

	@Override
	public Material findMaterialById(int materialId) {
		return this.getHibernateTemplate().get(Material.class, materialId);
	}

	@Override
	public int findTotalCount() {
		Long count  = (Long) this.getHibernateTemplate().find("select count(*) from Material").listIterator().next();
		return count.intValue();
	}

	@Override
	public List<Material> findAllForAndroid() {
		// TODO Auto-generated method stub
		List list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException,SQLException {
				Query query  = session.createQuery("from Material");
			
				List<Material> list = query.list();
				return list;
			}
		});
		return list;
	}

}

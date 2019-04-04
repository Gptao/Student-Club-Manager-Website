package com.nankai.app.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.nankai.app.dao.MaterialDao;
import com.nankai.app.dao.impl.MaterialDaoImpl;
import com.nankai.app.domain.Material;
import com.nankai.app.service.MaterialService;
import com.nankai.app.vo.MaterialPage;
@Transactional
public class MaterialServiceImpl implements MaterialService{
	private MaterialDao materialDao;
	
	public void setMaterialDao(MaterialDao materialDao) {
		this.materialDao = materialDao;
	}

	@Override
	public void add(Material material) {
		materialDao.add(material);
		
	}

	@Override
	public void update(Material material) {
		materialDao.update(material);
		
	}

	@Override
	public void delete(int materialId) {
		materialDao.delete(materialId);
	}

	@Override
	public MaterialPage findAll(int currentPage,int pageSize) {
		MaterialPage materialPage = new MaterialPage();
		List<Material> list = materialDao.findAll(currentPage, pageSize);
		materialPage.setDataList(list);
		materialPage.setCurrentPage(currentPage);
		materialPage.setPageSize(pageSize);
		int totalCount = materialDao.findTotalCount();
		materialPage.setTotalCount(totalCount);
		materialPage.setTotalPage(totalCount % pageSize ==0?totalCount/pageSize:totalCount/pageSize+1);
		return materialPage;
	}

	@Override
	public Material findMaterialById(int materialId) {
		return materialDao.findMaterialById(materialId);
	}

	@Override
	public List<Material> findAllForAndroid() {
		// TODO Auto-generated method stub
		return materialDao.findAllForAndroid();
	}

}

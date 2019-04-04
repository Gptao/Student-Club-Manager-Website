package com.nankai.app.dao;

import java.util.List;

import com.nankai.app.domain.Material;

public interface MaterialDao {
	public void add(Material material);
	public void update(Material material);
	public void delete(int materialId);
	public List<Material> findAll(int currentPage,int pageSize);
	public Material findMaterialById(int materialId);
	public int findTotalCount();
	public List<Material> findAllForAndroid();
}

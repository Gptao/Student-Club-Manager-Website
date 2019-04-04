package com.nankai.app.service;

import java.util.List;

import com.nankai.app.domain.Material;
import com.nankai.app.vo.MaterialPage;


public interface MaterialService {
		public void add(Material material);
		public void update(Material material);
		public void delete(int materialId);
		public MaterialPage findAll(int currentPage,int pageSize);
		public Material findMaterialById(int materialId);
		public List<Material> findAllForAndroid();
}

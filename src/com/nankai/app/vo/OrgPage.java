package com.nankai.app.vo;

import java.util.List;

import com.nankai.app.domain.Organization;

public class OrgPage {
	private int pageSize;//ÿҳ��ʾ��������¼
	private int currentPage;//��ǰҳ
	private  int totalCount;//������
	private int totalPage;//��ҳ����totalCount % pageSize ==0?totalCount/pageSize:totalCount/pageSize+1��
	private List<Organization> dataList;
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<Organization> getDataList() {
		return dataList;
	}
	public void setDataList(List<Organization> dataList) {
		this.dataList = dataList;
	}
}

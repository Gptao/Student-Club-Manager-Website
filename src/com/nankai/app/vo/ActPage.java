package com.nankai.app.vo;

import java.util.List;

import com.nankai.app.domain.Activity;

public class ActPage {
	private int pageSize;//每页显示多少条记录
	private int currentPage;//当前页
	private  int totalCount;//总条数
	private int totalPage;//总页数（totalCount % pageSize ==0?totalCount/pageSize:totalCount/pageSize+1）
	private List<Activity> dataList;
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
	public List<Activity> getDataList() {
		return dataList;
	}
	public void setDataList(List<Activity> dataList) {
		this.dataList = dataList;
	}
}

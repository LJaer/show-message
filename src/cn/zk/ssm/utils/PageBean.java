package cn.zk.ssm.utils;

import java.util.List;

import cn.zk.ssm.po.SecondCategory;

public class PageBean<T> {
	private int page; // 当前页数
	private int totalCount; // 总记录数
	private int totalPage; // 总页数
	private int limit;// 每页显示的记录数
	private int begin;//每页开始的记录
	private List<T> list;// 每页数据的集合
	private List<Integer> secondCategoryIdList;//二级分类的list

	public List<Integer> getSecondCategoryIdList() {
		return secondCategoryIdList;
	}

	public void setSecondCategoryIdList(List<Integer> secondCategoryIdList) {
		this.secondCategoryIdList = secondCategoryIdList;
	}

	public int getBegin() {
		return begin;
	}

	public void setBegin(int begin) {
		this.begin = begin;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
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

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
}
package cn.zk.ssm.service;

import java.util.List;

import cn.zk.ssm.po.FirstCategory;

public interface FirstCategoryService {
	//查询一级分类list
	public List<FirstCategory> findFirstCategoryList() throws Exception;
}

package cn.zk.ssm.service;

import java.util.List;

import cn.zk.ssm.po.SecondCategory;

public interface SecondCategoryService {
	//根据一级分类id查询二级分类id
	List<SecondCategory> findSecondCategoryByFirstCagetory(int id) throws Exception;
}

package cn.zk.ssm.service;

import java.util.List;

import cn.zk.ssm.po.FirstCategory;

public interface FirstCategoryService {
	//查询一级分类list
	public List<FirstCategory> findFirstCategoryList() throws Exception;
	
	//根据一级分类id查询一级分类
	FirstCategory selectByPrimaryKey(Integer id) throws Exception;
	
	//新增一级分类
	int insertFirstCategory(FirstCategory firstCategory) throws Exception;
	
	//删除一级分类
	int deleteByPrimaryKey(Integer id) throws Exception;
	
	//更新一级分类
	int updateByPrimaryKey(FirstCategory record) throws Exception;
}

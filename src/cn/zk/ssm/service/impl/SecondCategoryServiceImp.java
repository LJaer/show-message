package cn.zk.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.zk.ssm.mapper.SecondCategoryMapperCustom;
import cn.zk.ssm.po.SecondCategory;
import cn.zk.ssm.service.SecondCategoryService;

public class SecondCategoryServiceImp implements SecondCategoryService{
	
	@Autowired
	private SecondCategoryMapperCustom secondCategoryMapperCustom;
		
	//根据一级分类查询二级分类
	@Override
	public List<SecondCategory> findSecondCategoryByFirstCagetory(int id)
			throws Exception {
		return secondCategoryMapperCustom.findSecondCategoryByFirstCagetory(id);
	}

	//根据id查询二级分类
	@Override
	public SecondCategory selectByPrimaryKey(Integer id) throws Exception {
		return secondCategoryMapperCustom.selectByPrimaryKey(id);
	}

	@Override
	public int insert(SecondCategory record) throws Exception {
		return secondCategoryMapperCustom.insert(record);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) throws Exception {
		return secondCategoryMapperCustom.deleteByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKey(SecondCategory record) throws Exception {
		return secondCategoryMapperCustom.updateByPrimaryKey(record);
	}

}

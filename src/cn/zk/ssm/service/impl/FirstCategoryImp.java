package cn.zk.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.zk.ssm.mapper.FirstCategoryMapperCustom;
import cn.zk.ssm.po.FirstCategory;
import cn.zk.ssm.service.FirstCategoryService;

public class FirstCategoryImp implements FirstCategoryService {
	
	@Autowired
	private FirstCategoryMapperCustom firstCategoryCustom;

	@Override
	public List<FirstCategory> findFirstCategoryList() throws Exception {
		//通过FirstCategoryMapperCustom查询数据库
		return firstCategoryCustom.findFirstCategoryList();
	}

	@Override
	public FirstCategory selectByPrimaryKey(Integer id) throws Exception {
		return firstCategoryCustom.selectByPrimaryKey(id);
	}

	@Override
	public int insertFirstCategory(FirstCategory firstCategory)
			throws Exception {
		return firstCategoryCustom.insert(firstCategory);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) throws Exception {
		return firstCategoryCustom.deleteByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKey(FirstCategory record) throws Exception {
		return firstCategoryCustom.updateByPrimaryKey(record);
	}
}

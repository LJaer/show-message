package cn.zk.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.zk.ssm.mapper.CategoryImgMapperCustom;
import cn.zk.ssm.po.CategoryImg;
import cn.zk.ssm.service.CategoryImgService;

public class CategoryImgServiceImp implements CategoryImgService{
	
	@Autowired
	private CategoryImgMapperCustom categoryImgMapperCustom;

	@Override
	public List<CategoryImg> selectAllCategoryImg() throws Exception {
		return categoryImgMapperCustom.selectAllCategoryImg();
	}

}

package cn.zk.ssm.service;

import java.util.List;

import cn.zk.ssm.po.CategoryImg;

public interface CategoryImgService {
	
	//查找所有分类的img
	List<CategoryImg> selectAllCategoryImg() throws Exception;
	
	//根据id查找CategoryImg
    CategoryImg selectByPrimaryKey(Integer id) throws Exception;
    
    //新增一条CategoryImg
    int insert(CategoryImg record) throws Exception;
    
    //删除一条CategoryImg
    int deleteByPrimaryKey(Integer id) throws Exception;
    
}

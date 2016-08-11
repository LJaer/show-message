package cn.zk.ssm.mapper;

import cn.zk.ssm.po.CategoryImg;
import cn.zk.ssm.po.CategoryImgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CategoryImgMapperCustom {
	
	//查找所有分类图片
	List<CategoryImg> selectAllCategoryImg();
}
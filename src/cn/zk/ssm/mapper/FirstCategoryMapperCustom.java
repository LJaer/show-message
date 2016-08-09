package cn.zk.ssm.mapper;

import cn.zk.ssm.po.FirstCategory;
import cn.zk.ssm.po.FirstCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FirstCategoryMapperCustom extends FirstCategoryMapper{
	//一级列表查询
	public List<FirstCategory> findFirstCategoryList() throws Exception;
}
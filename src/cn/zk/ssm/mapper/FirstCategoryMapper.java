package cn.zk.ssm.mapper;

import cn.zk.ssm.po.FirstCategory;
import cn.zk.ssm.po.FirstCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FirstCategoryMapper {
    int countByExample(FirstCategoryExample example);

    int deleteByExample(FirstCategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FirstCategory record);

    int insertSelective(FirstCategory record);

    List<FirstCategory> selectByExample(FirstCategoryExample example);

    FirstCategory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FirstCategory record, @Param("example") FirstCategoryExample example);

    int updateByExample(@Param("record") FirstCategory record, @Param("example") FirstCategoryExample example);

    int updateByPrimaryKeySelective(FirstCategory record);

    int updateByPrimaryKey(FirstCategory record);
}
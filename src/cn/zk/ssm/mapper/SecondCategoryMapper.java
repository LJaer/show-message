package cn.zk.ssm.mapper;

import cn.zk.ssm.po.SecondCategory;
import cn.zk.ssm.po.SecondCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SecondCategoryMapper {
    int countByExample(SecondCategoryExample example);

    int deleteByExample(SecondCategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SecondCategory record);

    int insertSelective(SecondCategory record);

    List<SecondCategory> selectByExample(SecondCategoryExample example);

    SecondCategory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SecondCategory record, @Param("example") SecondCategoryExample example);

    int updateByExample(@Param("record") SecondCategory record, @Param("example") SecondCategoryExample example);

    int updateByPrimaryKeySelective(SecondCategory record);

    int updateByPrimaryKey(SecondCategory record);
}
package cn.zk.ssm.mapper;

import cn.zk.ssm.po.CategoryImg;
import cn.zk.ssm.po.CategoryImgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CategoryImgMapper {
    int countByExample(CategoryImgExample example);

    int deleteByExample(CategoryImgExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CategoryImg record);

    int insertSelective(CategoryImg record);

    List<CategoryImg> selectByExample(CategoryImgExample example);

    CategoryImg selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CategoryImg record, @Param("example") CategoryImgExample example);

    int updateByExample(@Param("record") CategoryImg record, @Param("example") CategoryImgExample example);

    int updateByPrimaryKeySelective(CategoryImg record);

    int updateByPrimaryKey(CategoryImg record);
}
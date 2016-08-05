package cn.zk.ssm.mapper;

import cn.zk.ssm.po.SecondCategory;
import cn.zk.ssm.po.SecondCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SecondCategoryMapperCustom extends SecondCategoryMapper{
    List<SecondCategory> findSecondCategoryByFirstCagetory(int id) throws Exception;
}
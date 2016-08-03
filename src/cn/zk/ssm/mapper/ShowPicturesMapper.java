package cn.zk.ssm.mapper;

import cn.zk.ssm.po.ShowPictures;
import cn.zk.ssm.po.ShowPicturesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShowPicturesMapper {
    int countByExample(ShowPicturesExample example);

    int deleteByExample(ShowPicturesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ShowPictures record);

    int insertSelective(ShowPictures record);

    List<ShowPictures> selectByExample(ShowPicturesExample example);

    ShowPictures selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ShowPictures record, @Param("example") ShowPicturesExample example);

    int updateByExample(@Param("record") ShowPictures record, @Param("example") ShowPicturesExample example);

    int updateByPrimaryKeySelective(ShowPictures record);

    int updateByPrimaryKey(ShowPictures record);
}
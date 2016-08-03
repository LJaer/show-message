package cn.zk.ssm.mapper;

import cn.zk.ssm.po.ShowPictures;
import cn.zk.ssm.po.ShowPicturesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShowPicturesMapperCustom {
	//查询用来展示的图片
	public List<ShowPictures> queryShowPictures() throws Exception;
}
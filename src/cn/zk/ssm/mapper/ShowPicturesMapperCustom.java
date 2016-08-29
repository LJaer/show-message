package cn.zk.ssm.mapper;

import cn.zk.ssm.po.ShowPictures;
import cn.zk.ssm.po.ShowPicturesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShowPicturesMapperCustom extends ShowPicturesMapper{
	//查询用来展示的图片
	public List<ShowPictures> queryShowPictures() throws Exception;
	//查询所有图片
	List<ShowPictures> queryAllPictures() throws Exception;
	//修改图片选择状态
	int changeChoice(ShowPictures showPictures) throws Exception;
}
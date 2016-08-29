package cn.zk.ssm.service;

import java.util.List;

import cn.zk.ssm.po.ShowPictures;

public interface ShowPicturesService {
	//查询用来展示的图片
	List<ShowPictures> queryShowPictures() throws Exception;
	
	//查询所有图片
	List<ShowPictures> queryAllPictures() throws Exception;
	
	//插入一条数据
	int insert(ShowPictures record) throws Exception;
	
	//删除一条数据
	int deleteByPrimaryKey(Integer id) throws Exception;
	
	//查询一条数据
	ShowPictures selectByPrimaryKey(Integer id) throws Exception;
	
	//修改图片选择状态
	int changeChoice(ShowPictures showPictures) throws Exception;
}

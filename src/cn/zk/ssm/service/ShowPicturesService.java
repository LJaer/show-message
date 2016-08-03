package cn.zk.ssm.service;

import java.util.List;

import cn.zk.ssm.po.ShowPictures;

public interface ShowPicturesService {
	//查询用来展示的图片
	List<ShowPictures> queryShowPictures() throws Exception;
}

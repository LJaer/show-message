package cn.zk.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.zk.ssm.mapper.ShowPicturesMapperCustom;
import cn.zk.ssm.po.ShowPictures;
import cn.zk.ssm.service.ShowPicturesService;

public class ShowPicturesServiceImp implements ShowPicturesService {

	@Autowired
	private ShowPicturesMapperCustom showPicturesMapperCustom;

	@Override
	public List<ShowPictures> queryShowPictures() throws Exception {
		// 查询用来展示的图片
		return showPicturesMapperCustom.queryShowPictures();
	}

}

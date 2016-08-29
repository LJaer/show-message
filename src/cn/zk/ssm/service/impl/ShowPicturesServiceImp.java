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

	@Override
	public List<ShowPictures> queryAllPictures() throws Exception {
		//用来查询所有图片
		return showPicturesMapperCustom.queryAllPictures();
	}

	@Override
	public int insert(ShowPictures record) throws Exception {
		return showPicturesMapperCustom.insert(record);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) throws Exception {
		return showPicturesMapperCustom.deleteByPrimaryKey(id);
	}

	@Override
	public ShowPictures selectByPrimaryKey(Integer id) throws Exception {
		return showPicturesMapperCustom.selectByPrimaryKey(id);
	}

	@Override
	public int changeChoice(ShowPictures showPictures) throws Exception {
		return showPicturesMapperCustom.changeChoice(showPictures);
	}

}

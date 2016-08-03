package cn.zk.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.zk.ssm.po.FirstCategory;
import cn.zk.ssm.po.ShowPictures;
import cn.zk.ssm.service.FirstCategoryService;
import cn.zk.ssm.service.ShowPicturesService;

/**
 * 展示图片的Controller
 * 
 * @author LJaer
 * 
 */
@Controller
public class ShowPicturesController {
	@Autowired
	private ShowPicturesService showPicturesService;

	// 查询用来展示的图片
	@RequestMapping("/queryShowPictures")
	public ModelAndView queryShowPicturesList() throws Exception {
		// 调用service查询数据库，查询用来展示的图片
		List<ShowPictures> showPicturesList = showPicturesService.queryShowPictures();

		// 返回ModelAndView
		ModelAndView modelAndView = new ModelAndView();

		// 相当于request.set的setAttribute，在jsp页面通过firstCategoryList取数据
		modelAndView.addObject("showPicturesList", showPicturesList);

		// 指定视图
		modelAndView.setViewName("jsp/show-pictures");

		return modelAndView;
	}
}

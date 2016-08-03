package cn.zk.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.zk.ssm.po.FirstCategory;
import cn.zk.ssm.service.FirstCategoryService;

/**
 * 一级分类的Controller
 * 
 * @author LJaer
 * 
 */
@Controller
public class FirstCategoryController {
	@Autowired
	private FirstCategoryService firstCategoryService;

	// 一级分类列表查询
	@RequestMapping("/queryFirstCategoryList")
	public ModelAndView queryFirstCategoryList() throws Exception {
		// 调用service查询数据库，查询一级分类列表
		List<FirstCategory> firstCategoryList = firstCategoryService
				.findFirstCategoryList();

		// 返回ModelAndView
		ModelAndView modelAndView = new ModelAndView();

		// 相当于request.set的setAttribute，在jsp页面通过firstCategoryList取数据
		modelAndView.addObject("firstCategoryList", firstCategoryList);

		// 指定视图
		modelAndView.setViewName("jsp/top");

		return modelAndView;
	}
}

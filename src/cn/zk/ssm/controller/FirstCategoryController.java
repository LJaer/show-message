package cn.zk.ssm.controller;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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

	// 一级分类列表查询,返回json
	@RequestMapping("/queryFirstCategoryList")
	public @ResponseBody List<FirstCategory> queryFirstCategoryList() throws Exception {
		// 调用service查询数据库，查询一级分类列表
		return firstCategoryService.findFirstCategoryList();
	}

	/**
	 * 获取所有一级分类，返回json
	 */
	// 获取所有一级分类
	@RequestMapping("findFirstCategoryList")
	public @ResponseBody List<FirstCategory> findFirstCategoryList() throws Exception {
		return firstCategoryService.findFirstCategoryList();
	}
}
















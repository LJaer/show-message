package cn.zk.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.zk.ssm.po.Article;
import cn.zk.ssm.po.FirstCategory;
import cn.zk.ssm.po.SecondCategory;
import cn.zk.ssm.po.ShowPictures;
import cn.zk.ssm.service.FirstCategoryService;
import cn.zk.ssm.service.SecondCategoryService;

/**
 * Ueditor的Controller
 * 
 * @author LJaer
 * 
 */
@Controller
public class UeditorController {
	@Autowired
	private FirstCategoryService firstCategoryService;
	@Autowired
	private SecondCategoryService secondCategoryService;
	
	@RequestMapping("/saveUeditor")
	public void saveUeditor(HttpServletRequest request) throws Exception {
		String name = request.getParameter("content");
		System.out.println(name);
	}
	
}

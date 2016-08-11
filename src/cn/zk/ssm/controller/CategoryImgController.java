package cn.zk.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.zk.ssm.po.CategoryImg;
import cn.zk.ssm.service.CategoryImgService;

@Controller
public class CategoryImgController {
	
	@Autowired
	private CategoryImgService categoryImgService;
	
	@RequestMapping("/selectAllCategoryImg")
	public @ResponseBody List<CategoryImg> selectAllCategoryImg() throws Exception{
		return categoryImgService.selectAllCategoryImg();
	}
}

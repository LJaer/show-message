package cn.zk.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.zk.ssm.po.FirstCategory;
import cn.zk.ssm.po.SecondCategory;
import cn.zk.ssm.service.SecondCategoryService;

/**
 * 二级分类的controller
 * @author LJaer
 *
 */
@Controller
public class SecondCategoryController {
	@Autowired
	private SecondCategoryService secondCategoryService;
	
	//根据一级分类的id查询二级分类的idlist
	@RequestMapping("/findSecondCategoryListByFirstCategoryId")
	public  @ResponseBody List<SecondCategory> findSecondCategoryListByFirstCategoryId(@RequestParam(value="firstCategoryId",required=true) Integer id) throws Exception{
		return secondCategoryService.findSecondCategoryByFirstCagetory(id);
	}
}

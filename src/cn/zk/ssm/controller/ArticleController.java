package cn.zk.ssm.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.zk.ssm.po.Article;
import cn.zk.ssm.po.FirstCategory;
import cn.zk.ssm.service.ArticleService;
import cn.zk.ssm.service.FirstCategoryService;

/**
 * article的controller
 * @author LJaer
 *
 */
@Controller
public class ArticleController {
	
	@Autowired
	private ArticleService articleService;
	
	/**
	 * 插入一条新的article
	 * @param article
	 * @throws Exception 
	 */
	@RequestMapping("/insertArticle")
	public void insertArticle(Article article) throws Exception {
		Date date = new Date();
		article.setTime(date);
		article.setReview(0);
		article.setBrowse(0);
		articleService.insertArticle(article);
	}
}














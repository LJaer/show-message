package cn.zk.ssm.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.zk.ssm.po.Article;
import cn.zk.ssm.po.ArticleCustom;
import cn.zk.ssm.po.ArticleStyle1;
import cn.zk.ssm.po.ArticleStyle2;
import cn.zk.ssm.po.FirstCategory;
import cn.zk.ssm.po.SecondCategory;
import cn.zk.ssm.service.ArticleService;
import cn.zk.ssm.service.FirstCategoryService;
import cn.zk.ssm.service.SecondCategoryService;
import cn.zk.ssm.utils.HtmlParse;

/**
 * article的controller
 * @author LJaer
 *
 */
@Controller
public class ArticleController {
	
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private SecondCategoryService secondCategoryService;
	
	@Autowired 
	private FirstCategoryService firstCategoryService;
	
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
	
	/**
	 * 查询文章列表根据一级id和二级id
	 * @param firstcategoryid 一级分类的id，当id=-1时，表示没有传入一级分类
	 * @param secondcategoryid 二级分类的id 当id=-1时，表示没有传入二级分类
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/queryArticleList")
	public ModelAndView queryArticleList(int firstcategoryid,int secondcategoryid,int page) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		List<ArticleStyle1> articleStyle1List = new ArrayList();
		if(secondcategoryid==-1){
			//根据一级id查询所有二级id
			List<SecondCategory> secondCategoryList = new ArrayList();
			secondCategoryList = secondCategoryService.findSecondCategoryByFirstCagetory(firstcategoryid);
			ArticleCustom articleCustom = new ArticleCustom();
			articleCustom.setSecondCategoryList(secondCategoryList);
			List<Article> articleList = articleService.findArticleList(articleCustom);
			articleStyle1List = articleToArticleStyle1(articleList);
		}else{
		}
		modelAndView.addObject("articleStyle1List",articleStyle1List);
		modelAndView.setViewName("jsp/articlelist-center");
		return modelAndView;
	}
	
	/**
	 * 查询最近的三篇文章
	 */
	@RequestMapping("/queryLastArticle")
	public ModelAndView queryLastArticle() throws Exception{
		List<Article> articleList = articleService.findLastArticleList();
		List<ArticleStyle1> articleStyle1List = articleToArticleStyle1(articleList);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("articleStyle1List", articleStyle1List);
		modelAndView.setViewName("jsp/index-lastnew");
		return modelAndView;
	}
	
	/**
	 * 查询所有分类以及该分类下的六篇文章
	 */
	@RequestMapping("/queryLastArticle2")
	public ModelAndView queryLastArticle2() throws Exception{
		ModelAndView modelAndView = new ModelAndView();
	 	List<ArticleStyle2> articleStyle2List = articleService.findLastArticle1List();
	 	modelAndView.addObject("articleStyle2List", articleStyle2List);
		modelAndView.setViewName("jsp/index-lastnew2");
		return modelAndView;
	}
	
	/**
	 * 将Article转为ArticleStyle1
	 * @throws Exception 
	 */
	private List<ArticleStyle1> articleToArticleStyle1(List<Article> articleList) throws Exception{
		List<ArticleStyle1> articleStyle1List = new ArrayList();
		for (int i = 0; i < articleList.size(); i++) {
			Article article = articleList.get(i);
			ArticleStyle1 articleStyle1 = new ArticleStyle1();
			articleStyle1.setArticle(article);
			String html = article.getHtml();
			Elements elements = HtmlParse.getInstance().getHtmlImg(html);
			//设置正文图片
			if(elements.size()>0){
				for (int j = 0; j < 1; j++) {//这里只需要取出来一张照片即可
					Element element = elements.get(j);
					String src = element.attr("src");
					articleStyle1.setContextimage(src);
				}
			}
			//设置正文纯文本
			String text = HtmlParse.getInstance().getHtmlText(html);
			if(text.length()>170){
				text = text.substring(0, 170);
			}
			text += "...";
			articleStyle1.setText(text);
			//设置二级分类图标
			int id = article.getSecondcategoryid();
			SecondCategory secondCategory = secondCategoryService.selectByPrimaryKey(id);
			String secondCategoryImage = secondCategory.getImg();
			articleStyle1.setSecondcategoryimage(secondCategoryImage);
			articleStyle1List.add(articleStyle1);
		}
		return articleStyle1List;
	}
}













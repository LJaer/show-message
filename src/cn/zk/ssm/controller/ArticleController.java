package cn.zk.ssm.controller;

import java.util.Date;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.zk.ssm.po.Article;
import cn.zk.ssm.po.ArticleStyle1;
import cn.zk.ssm.po.SecondCategory;
import cn.zk.ssm.service.ArticleService;
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
	 * 查询最近的三篇文章
	 */
	@RequestMapping("/queryLastArticle")
	public ModelAndView queryLastArticle() throws Exception{
		List<ArticleStyle1> articleStyle1List = articleService.findLastArticleList();
		
		//对数据进行处理，获取图片地址和纯文本
		for (int i = 0; i < articleStyle1List.size(); i++) {
			String html = articleStyle1List.get(i).getHtml();
			Elements elements=HtmlParse.getInstance().getHtmlImg(html);
			//设置正文图片
			for (int j = 0; j < 1; j++) {//这里只需要取出来一张照片即可
				Element element = elements.get(j);
				String src = element.attr("src");
				articleStyle1List.get(i).setContextimage(src);
			}
			//设置正文纯文本
			String text = HtmlParse.getInstance().getHtmlText(html);
			text = text.substring(0, 170);
			text += "...";
			articleStyle1List.get(i).setText(text);
			//设置二级分类图标
			int id = articleStyle1List.get(i).getSecondcategoryid();
			SecondCategory secondCategory = secondCategoryService.selectByPrimaryKey(id);
			String secondCategoryImage = secondCategory.getImg();
			articleStyle1List.get(i).setSecondcategoryimage(secondCategoryImage);
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("articleStyle1List", articleStyle1List);
		modelAndView.setViewName("jsp/index-lastnew");
		return modelAndView;
	}
}














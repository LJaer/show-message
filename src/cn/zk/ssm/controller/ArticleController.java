package cn.zk.ssm.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.zk.ssm.po.Article;
import cn.zk.ssm.po.ArticleStyle1;
import cn.zk.ssm.po.ArticleStyle2;
import cn.zk.ssm.po.CategoryImg;
import cn.zk.ssm.po.SecondCategory;
import cn.zk.ssm.service.ArticleService;
import cn.zk.ssm.service.CategoryImgService;
import cn.zk.ssm.service.FirstCategoryService;
import cn.zk.ssm.service.SecondCategoryService;
import cn.zk.ssm.utils.HtmlParse;
import cn.zk.ssm.utils.PageBean;


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
	
	@Autowired
	private CategoryImgService categoryImgService;
	
	//插入一条新的article
	@RequestMapping("/insertArticle")
	@ResponseBody
	public int insertArticle(Article article) throws Exception {
		Date date = new Date();
		article.setTime(date);
		article.setBrowse(0);
		return articleService.insertArticle(article);
	}
	
	//删除一条article
	@RequestMapping("/delArticle")
	@ResponseBody
	public int delArticle(int id) throws Exception{
		return articleService.delArticle(id);
	}
	
	//更新一条article
	@RequestMapping("/updateArticleSelective")
	@ResponseBody
	public int updateArticleSelective(Article article) throws Exception{
		return articleService.updateByPrimaryKeySelective(article);
	}
	
	//查询一条article
	@RequestMapping("/selectByPrimaryKey")
	@ResponseBody
	public Article selectByPrimaryKey(int id) throws Exception{
		return articleService.selectByPrimaryKey(id);
	}
	
	@RequestMapping("/ArticleList")
	public String ArticleList(){
		return "jsp/articlelist/articlelist";
	}
	
	@RequestMapping("/queryArticleListByFirstCategoryIdAndPage")
	@ResponseBody
	public PageBean<ArticleStyle1> queryArticleListByFirstCategoryIdAndPage(PageBean<ArticleStyle1> pageBean) throws Exception {
		return articleService.queryArticleListByFirstCategoryIdAndPage(pageBean);
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
	 * 文章详情
	 */
	@RequestMapping("/articleDetail")
	public ModelAndView articleDetail(int articleId) throws Exception{
		ModelAndView modelAndView = new ModelAndView();

		Article article = articleService.queryArticle(articleId);
		modelAndView.addObject("article", article);
		
		//每次访问文章，访问量加1
		int browse = article.getBrowse();
		article.setBrowse(browse+1);
		articleService.updateByPrimaryKeySelective(article);
		
		modelAndView.setViewName("jsp/articledetail/article-detail");
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
			if(html!=null){
				Elements elements = HtmlParse.getInstance().getHtmlImg(html);
				//设置正文图片
				if(elements.size()>0){
					String src = "";
					for (int j = 0; j < 1; j++) {//这里只需要取出来一张照片即可
						Element element = elements.get(j);
						src = element.attr("src");
						articleStyle1.setContextimage(src);
					}
				}
				//设置正文纯文本
				String text = HtmlParse.getInstance().getHtmlText(html);
				if(text.length()>170){
					text = text.substring(0, 150);
				}
				text += "...";
				articleStyle1.setText(text);
				//设置二级分类图标
				int id = article.getSecondcategoryid();
				SecondCategory secondCategory = secondCategoryService.selectByPrimaryKey(id);
				int imgId = secondCategory.getImg();
				//根据ImgId查询图片路径
				CategoryImg categoryImg = categoryImgService.selectByPrimaryKey(imgId);
				String imgSrc = categoryImg.getSrc();
				articleStyle1.setSecondcategoryimage(imgSrc);
				articleStyle1List.add(articleStyle1);
			}
		}
		return articleStyle1List;
	}
	
	//根据二级分类id查询文章了列表
	@RequestMapping("/findArticleListBySecondCategoryIdAndPage")
	@ResponseBody
	public PageBean<Article> findArticleListBySecondCategoryId(PageBean pageBean) throws Exception{
		return articleService.findArticleListBySecondCategoryIdAndPage(pageBean);
	}
	
}













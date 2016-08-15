package cn.zk.ssm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;

import cn.zk.ssm.mapper.ArticleMapper;
import cn.zk.ssm.mapper.ArticleMapperCustom;
import cn.zk.ssm.mapper.FirstCategoryMapperCustom;
import cn.zk.ssm.po.Article;
import cn.zk.ssm.po.ArticleCustom;
import cn.zk.ssm.po.ArticleStyle1;
import cn.zk.ssm.po.ArticleStyle2;
import cn.zk.ssm.po.FirstCategory;
import cn.zk.ssm.po.SecondCategory;
import cn.zk.ssm.service.ArticleService;
import cn.zk.ssm.utils.HtmlParse;

public class ArticleServiceImp implements ArticleService{
	
	@Autowired
	private ArticleMapperCustom articleMapperCustom;
	
	@Autowired
	private FirstCategoryMapperCustom firstCategoryMapperCustom;
	
	@Override
	public int insertArticle(Article article) throws Exception {
		return articleMapperCustom.insert(article);
	}

	//查询三篇最新的文章
	@Override
	public List<Article> findLastArticleList() throws Exception {
		return articleMapperCustom.findLastArticleList();
	}

	//查询所有分类和分类下最新的六篇文章
	@Override
	public List<ArticleStyle2> findLastArticle1List() throws Exception {
		List<ArticleStyle2> articleStyle2List = new ArrayList();
		//查询到所有一级分类list
		List<FirstCategory> firstCategoryList = firstCategoryMapperCustom.findFirstCategoryList();
		for (int i = 0; i < firstCategoryList.size(); i++) {
			ArticleStyle2 articleStyle2 = new ArticleStyle2();
			articleStyle2.setFirstCategory(firstCategoryList.get(i));
			Integer firstCategoryId = firstCategoryList.get(i).getId();
			//根据一级分类id查询该分类下最新的六篇文章
			List<Article> articleList = articleMapperCustom.findFirstCategoryLastArticleList(firstCategoryId);
			if(articleList.size()>0){
				String firstArticleContext = HtmlParse.getInstance().getHtmlText(articleList.get(0).getHtml());
				if(firstArticleContext.length()>50){
					firstArticleContext = firstArticleContext.substring(0, 50);
				}
				Elements firstArticleImgList = HtmlParse.getInstance().getHtmlImg(articleList.get(0).getHtml());
				articleStyle2.setArticleList(articleList);
				articleStyle2.setFirstArticleContext(firstArticleContext);
				if(firstArticleImgList.size()>0){
					articleStyle2.setFirstArticleImg(firstArticleImgList.get(0).attr("src"));
				}
			}
			articleStyle2List.add(articleStyle2);
		}
		return articleStyle2List;
	}

	//查询文章列表
	@Override
	public List<Article> findArticleList(ArticleCustom articleCustom)
			throws Exception {
		return articleMapperCustom.findArticleList(articleCustom);
	}

	@Override
	public Article queryArticle(int id) throws Exception {
		return articleMapperCustom.selectByPrimaryKey(id);
	}

	@Override
	public List<Article> findArticleListBySecondCategoryId(int secondCategoryId)
			throws Exception {
		return articleMapperCustom.findArticleListBySecondCategoryId(secondCategoryId);
	}

	@Override
	public int delArticle(int id) throws Exception {
		return articleMapperCustom.deleteByPrimaryKey(id);
	}

	@Override
	public int updateArticle(Article article) throws Exception {
		return articleMapperCustom.updateByPrimaryKey(article);
	}

	@Override
	public Article selectByPrimaryKey(Integer id) {
		return articleMapperCustom.selectByPrimaryKey(id);
	}

}































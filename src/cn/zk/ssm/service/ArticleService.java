package cn.zk.ssm.service;

import java.util.List;

import cn.zk.ssm.po.Article;
import cn.zk.ssm.po.ArticleCustom;
import cn.zk.ssm.po.ArticleStyle1;
import cn.zk.ssm.po.ArticleStyle2;
import cn.zk.ssm.po.SecondCategory;

public interface ArticleService {
	//insert一条article
	void insertArticle(Article article) throws Exception;
	//查询三篇最新的文章
	List<Article> findLastArticleList() throws Exception;
	//查询所有分类和最近六篇文章
	List<ArticleStyle2> findLastArticle1List() throws Exception;
	//查询文章列表
	List<Article> findArticleList(ArticleCustom articleCustom) throws Exception;
}

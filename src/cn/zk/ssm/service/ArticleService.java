package cn.zk.ssm.service;

import java.util.List;

import cn.zk.ssm.po.Article;
import cn.zk.ssm.po.ArticleStyle1;

public interface ArticleService {
	//insert一条article
	void insertArticle(Article article) throws Exception;
	//查询三篇最新的文章
	List<ArticleStyle1> findLastArticleList() throws Exception;
}

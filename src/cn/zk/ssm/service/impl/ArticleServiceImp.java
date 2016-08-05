package cn.zk.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.zk.ssm.mapper.ArticleMapper;
import cn.zk.ssm.mapper.ArticleMapperCustom;
import cn.zk.ssm.po.Article;
import cn.zk.ssm.po.ArticleStyle1;
import cn.zk.ssm.service.ArticleService;

public class ArticleServiceImp implements ArticleService{
	
	@Autowired
	private ArticleMapperCustom articleMapperCustom;
	
	@Override
	public void insertArticle(Article article) throws Exception {
		articleMapperCustom.insert(article);
	}

	//查询三篇最新的文章
	@Override
	public List<ArticleStyle1> findLastArticleList() throws Exception {
		return articleMapperCustom.findLastArticleList();
	}

}

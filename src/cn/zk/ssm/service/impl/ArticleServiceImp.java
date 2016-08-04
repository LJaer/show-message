package cn.zk.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import cn.zk.ssm.mapper.ArticleMapper;
import cn.zk.ssm.mapper.ArticleMapperCustom;
import cn.zk.ssm.po.Article;
import cn.zk.ssm.service.ArticleService;

public class ArticleServiceImp implements ArticleService{
	
	@Autowired
	private ArticleMapperCustom articleMapperCustom;
	
	@Override
	public void insertArticle(Article article) throws Exception {
		articleMapperCustom.insert(article);
	}

}

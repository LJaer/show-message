package cn.zk.ssm.mapper;

import cn.zk.ssm.po.Article;
import cn.zk.ssm.po.ArticleExample;
import cn.zk.ssm.po.ArticleStyle1;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ArticleMapperCustom extends ArticleMapper{
	
	//查询三篇最新的文章
	List<ArticleStyle1> findLastArticleList() throws Exception;
	
	//查询一级分类下最新六篇文章
	List<Article> findFirstCategoryLastArticleList(int id) throws Exception;
}
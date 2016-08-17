package cn.zk.ssm.mapper;

import java.util.List;

import cn.zk.ssm.po.Article;
import cn.zk.ssm.po.ArticleCustom;
import cn.zk.ssm.po.SecondCategory;
import cn.zk.ssm.utils.PageBean;

public interface ArticleMapperCustom extends ArticleMapper{
	
	//查询三篇最新的文章
	List<Article> findLastArticleList() throws Exception;
	
	//查询一级分类下最新六篇文章
	List<Article> findFirstCategoryLastArticleList(int id) throws Exception;
	
	//查询文章列表
	List<Article> findArticleList(ArticleCustom articleCustom) throws Exception;
	
	//根据二级分类id查询文章列表
	int findArticleCountBySecondCategoryId(PageBean pageBean) throws Exception;

	//根据二级分类id和page查询文章列表
	List<Article> findArticleListBySecondCategoryIdAndPage(PageBean pageBean) throws Exception;
	
}
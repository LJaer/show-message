package cn.zk.ssm.po;

import java.util.List;


/**
 * 文章样式2：一级分类图标，名称，文章图片，纯文本
 * 首页第二部分
 * @author LJaer
 *
 */
public class ArticleStyle2{
	private FirstCategory firstCategory;//一级分类
	private List<Article> articleList;//一级分类下文章
	private String firstArticleImg;//一级分类下第一篇文章图片
	private String firstArticleContext;//一级分类下第一篇文章纯文本
	public FirstCategory getFirstCategory() {
		return firstCategory;
	}
	public void setFirstCategory(FirstCategory firstCategory) {
		this.firstCategory = firstCategory;
	}
	public List<Article> getArticleList() {
		return articleList;
	}
	public void setArticleList(List<Article> articleList) {
		this.articleList = articleList;
	}
	public String getFirstArticleImg() {
		return firstArticleImg;
	}
	public void setFirstArticleImg(String firstArticleImg) {
		this.firstArticleImg = firstArticleImg;
	}
	public String getFirstArticleContext() {
		return firstArticleContext;
	}
	public void setFirstArticleContext(String firstArticleContext) {
		this.firstArticleContext = firstArticleContext;
	}
}

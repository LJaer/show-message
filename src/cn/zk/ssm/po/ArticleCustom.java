package cn.zk.ssm.po;

import java.util.List;

/**
 * articlelist
 * @author LJaer
 *
 */
public class ArticleCustom {
	private FirstCategory firstCategory;//一级分类
	private List<SecondCategory> secondCategoryList;//该一级分类下的二级分类
	private int page;//当前页数
	private List<Article> articleList;//二级分类文章
	public FirstCategory getFirstCategory() {
		return firstCategory;
	}
	public void setFirstCategory(FirstCategory firstCategory) {
		this.firstCategory = firstCategory;
	}
	public List<SecondCategory> getSecondCategoryList() {
		return secondCategoryList;
	}
	public void setSecondCategoryList(List<SecondCategory> secondCategoryList) {
		this.secondCategoryList = secondCategoryList;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public List<Article> getArticleList() {
		return articleList;
	}
	public void setArticleList(List<Article> articleList) {
		this.articleList = articleList;
	}
}

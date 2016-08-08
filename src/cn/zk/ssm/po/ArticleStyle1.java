package cn.zk.ssm.po;

import java.util.List;


/**
 * 文章样式:二级分类图标，文章名，文章图片，文章纯文本
 * image文章所属一级分类的图片
 * text文章内容纯文本
 * secondcategoryimg:二级分类图标
 * @author LJaer
 *
 */
public class ArticleStyle1{
	private String contextimage;//正文图片
	private String text;//正文纯文本
	private String secondcategoryimage;//二级分类图标
	private Article article;//article
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public String getContextimage() {
		return contextimage;
	}
	public void setContextimage(String contextimage) {
		this.contextimage = contextimage;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getSecondcategoryimage() {
		return secondcategoryimage;
	}
	public void setSecondcategoryimage(String secondcategoryimage) {
		this.secondcategoryimage = secondcategoryimage;
	}
}

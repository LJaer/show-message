package cn.zk.ssm.po;


/**
 * 文章样式
 * image文章所属一级分类的图片
 * text文章内容纯文本
 * secondcategoryimg:二级分类图标
 * @author LJaer
 *
 */
public class ArticleStyle1 extends Article{
	private String contextimage;//正文图片
	private String text;//正文纯文本
	private String secondcategoryimage;//二级分类图标
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

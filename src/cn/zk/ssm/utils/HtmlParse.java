package cn.zk.ssm.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class HtmlParse {

	private static HtmlParse instance = null;
	private HtmlParse(){}
	public static HtmlParse getInstance(){
		if(instance==null){
			instance = new HtmlParse();
		}
		return instance;
	}
	
	
	//获取html中的所有img元素
	public Elements getHtmlImg(String html){
		Document doc = Jsoup.parse(html);
		Elements elements=doc.select("img");
		return elements;
	}
	
	//获取html中的纯文本
	public String getHtmlText(String html){
		Document doc = Jsoup.parse(html);
		String text = doc.body().text();
		return text;
	}
}



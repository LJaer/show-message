package cn.zk.ssm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;

import cn.zk.ssm.mapper.ArticleMapperCustom;
import cn.zk.ssm.mapper.FirstCategoryMapperCustom;
import cn.zk.ssm.po.Article;
import cn.zk.ssm.po.ArticleCustom;
import cn.zk.ssm.po.ArticleStyle1;
import cn.zk.ssm.po.ArticleStyle2;
import cn.zk.ssm.po.CategoryImg;
import cn.zk.ssm.po.FirstCategory;
import cn.zk.ssm.po.SecondCategory;
import cn.zk.ssm.service.ArticleService;
import cn.zk.ssm.service.CategoryImgService;
import cn.zk.ssm.service.SecondCategoryService;
import cn.zk.ssm.utils.HtmlParse;
import cn.zk.ssm.utils.PageBean;

public class ArticleServiceImp implements ArticleService {

	@Autowired
	private ArticleMapperCustom articleMapperCustom;

	@Autowired
	private FirstCategoryMapperCustom firstCategoryMapperCustom;

	@Autowired
	private CategoryImgService categoryImgService;

	@Autowired
	private SecondCategoryService secondCategoryService;

	@Override
	public int insertArticle(Article article) throws Exception {
		return articleMapperCustom.insert(article);
	}

	// 查询三篇最新的文章
	@Override
	public List<Article> findLastArticleList() throws Exception {
		return articleMapperCustom.findLastArticleList();
	}

	// 查询所有分类和分类下最新的六篇文章
	@Override
	public List<ArticleStyle2> findLastArticle1List() throws Exception {
		List<ArticleStyle2> articleStyle2List = new ArrayList();
		// 查询到所有一级分类list
		List<FirstCategory> firstCategoryList = firstCategoryMapperCustom
				.findFirstCategoryList();
		for (int i = 0; i < firstCategoryList.size(); i++) {
			ArticleStyle2 articleStyle2 = new ArticleStyle2();
			articleStyle2.setFirstCategory(firstCategoryList.get(i));
			Integer firstCategoryId = firstCategoryList.get(i).getId();
			// 根据categoryId查询categoryImg
			int categoryId = firstCategoryList.get(i).getImg();
			CategoryImg categoryImg = categoryImgService
					.selectByPrimaryKey(categoryId);
			articleStyle2.setCategoryImgSrc(categoryImg.getName());

			// 根据一级分类id查询该分类下最新的六篇文章
			List<Article> articleList = articleMapperCustom
					.findFirstCategoryLastArticleList(firstCategoryId);
			if (articleList.size() > 0) {
				String firstArticleContext = HtmlParse.getInstance()
						.getHtmlText(articleList.get(0).getHtml());
				if (firstArticleContext.length() > 50) {
					firstArticleContext = firstArticleContext.substring(0, 50);
				}
				Elements firstArticleImgList = HtmlParse.getInstance()
						.getHtmlImg(articleList.get(0).getHtml());
				articleStyle2.setArticleList(articleList);
				articleStyle2.setFirstArticleContext(firstArticleContext);
				if (firstArticleImgList.size() > 0) {
					articleStyle2.setFirstArticleImg(firstArticleImgList.get(0)
							.attr("src"));
				}
			}
			articleStyle2List.add(articleStyle2);
		}
		return articleStyle2List;
	}

	// 查询文章列表
	@Override
	public List<Article> findArticleList(ArticleCustom articleCustom)
			throws Exception {
		return articleMapperCustom.findArticleList(articleCustom);
	}

	@Override
	public Article queryArticle(int id) throws Exception {
		return articleMapperCustom.selectByPrimaryKey(id);
	}

	@Override
	public int findArticleCountBySecondCategoryId(PageBean pageBean)
			throws Exception {
		return articleMapperCustom.findArticleCountBySecondCategoryId(pageBean);
	}

	@Override
	public int delArticle(int id) throws Exception {
		return articleMapperCustom.deleteByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Article article) throws Exception {
		return articleMapperCustom.updateByPrimaryKeySelective(article);
	}

	@Override
	public Article selectByPrimaryKey(Integer id) {
		return articleMapperCustom.selectByPrimaryKey(id);
	}

	@Override
	public PageBean<Article> findArticleListBySecondCategoryIdAndPage(
			PageBean pageBean) throws Exception {
		// 设置每页显示记录数
		int limit = 10;
		pageBean.setLimit(limit);
		// 设置总记录数：
		int totalCount = articleMapperCustom
				.findArticleCountBySecondCategoryId(pageBean);
		pageBean.setTotalCount(totalCount);
		// 设置总页数
		int totalPage = 0;
		if (totalCount % limit == 0) {
			totalPage = totalCount / limit;
		} else {
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		// 设置每页显示数据集合
		int begin = (pageBean.getPage() - 1) * limit;
		pageBean.setBegin(begin);
		List<Article> list = articleMapperCustom
				.findArticleListBySecondCategoryIdAndPage(pageBean);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public PageBean<ArticleStyle1> queryArticleListByFirstCategoryIdAndPage(
			PageBean<ArticleStyle1> pageBean) throws Exception {
		// 设置每页显示记录数
		int limit = 10;
		pageBean.setLimit(limit);
		int firstCategoryId = pageBean.getFirstCategoryId();
		// 根据一级id查询所有二级id
		List<SecondCategory> secondCategoryList = new ArrayList();
		secondCategoryList = secondCategoryService
				.findSecondCategoryByFirstCagetory(firstCategoryId);
		List<Integer> secondCategoryIdList = new ArrayList();
		for (int i = 0; i < secondCategoryList.size(); i++) {
			secondCategoryIdList.add(secondCategoryList.get(i).getId());
		}
		pageBean.setSecondCategoryIdList(secondCategoryIdList);
		// 设置总记录数：
		int totalCount = articleMapperCustom
				.findArticleCountBySecondCategoryId(pageBean);
		pageBean.setTotalCount(totalCount);
		// 设置总页数
		int totalPage = 0;
		if (totalCount % limit == 0) {
			totalPage = totalCount / limit;
		} else {
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		// 设置每页显示数据集合
		int begin = (pageBean.getPage() - 1) * limit;
		pageBean.setBegin(begin);

		List<Article> list = articleMapperCustom
				.findArticleListBySecondCategoryIdAndPage(pageBean);

		pageBean.setList(articleToArticleStyle1(list));
		return pageBean;
	}

	/**
	 * 将Article转为ArticleStyle1
	 * 
	 * @throws Exception
	 */
	private List<ArticleStyle1> articleToArticleStyle1(List<Article> articleList)
			throws Exception {
		List<ArticleStyle1> articleStyle1List = new ArrayList();
		for (int i = 0; i < articleList.size(); i++) {
			Article article = articleList.get(i);
			ArticleStyle1 articleStyle1 = new ArticleStyle1();
			articleStyle1.setArticle(article);
			String html = article.getHtml();
			Elements elements = HtmlParse.getInstance().getHtmlImg(html);
			// 设置正文图片
			if (elements.size() > 0) {
				String src = "";
				for (int j = 0; j < 1; j++) {// 这里只需要取出来一张照片即可
					Element element = elements.get(j);
					src = element.attr("src");
					articleStyle1.setContextimage(src);
				}
			}
			// 设置正文纯文本
			String text = HtmlParse.getInstance().getHtmlText(html);
			if (text.length() > 170) {
				text = text.substring(0, 170);
			}
			text += "...";
			articleStyle1.setText(text);
			// 设置二级分类图标
			int id = article.getSecondcategoryid();
			SecondCategory secondCategory = secondCategoryService
					.selectByPrimaryKey(id);
			int imgId = secondCategory.getImg();
			// 根据ImgId查询图片路径
			CategoryImg categoryImg = categoryImgService
					.selectByPrimaryKey(imgId);
			String imgSrc = categoryImg.getName();
			articleStyle1.setSecondcategoryimage(imgSrc);
			articleStyle1List.add(articleStyle1);
		}
		return articleStyle1List;
	}

}

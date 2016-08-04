package cn.zk.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.zk.ssm.po.ShowPictures;

/**
 * Ueditor的Controller
 * 
 * @author LJaer
 * 
 */
@Controller
public class UeditorController {
	// 查询用来展示的图片
	@RequestMapping("/saveUeditor")
	public void saveUeditor(HttpServletRequest request) throws Exception {
		String name = request.getParameter("content");
		System.out.println(name);
	}
}

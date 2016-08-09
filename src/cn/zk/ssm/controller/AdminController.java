package cn.zk.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

	/**
	 * 登录界面
	 * @return
	 */
	@RequestMapping("/admin")
	private ModelAndView adminLogin(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("jsp/admin/login");
		return modelAndView;
	}
	
	
	
}

package cn.zk.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.zk.ssm.po.User;
import cn.zk.ssm.service.UserService;

@Controller
public class AdminController {
	
	@Autowired
	private UserService userService;

	/**
	 * 登录界面
	 * @return
	 */
	@RequestMapping("/admin")
	private ModelAndView admin(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("jsp/admin/login");
		return modelAndView;
	}
	
	/**
	 * 用户名密码检测
	 * @throws Exception 
	 */
	@RequestMapping("/login")
	private ModelAndView login(User user) throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		//通过Service接口查询用户是否存在
		User resultUser = userService.selectByNameAndPassword(user);
		if(resultUser!=null){

		}else{
			modelAndView.setViewName("jsp/admin/login");
		}
		return modelAndView;
	}
	
	
}

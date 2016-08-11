package cn.zk.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
	@RequestMapping("/login")
	private ModelAndView login(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("jsp/admin/login");
		return modelAndView;
	}
	
	/**
	 * 用户名密码检测
	 * @return 
	 * @throws Exception 
	 */
	@RequestMapping("/checkUser")
	private @ResponseBody User checkUser(String name,String password) throws Exception{
		User user = new User();
		user.setName(name);
		user.setPassword(password);
		//通过Service接口查询用户是否存在
		User resultUser = userService.selectByNameAndPassword(user);
		if(resultUser!=null){
			return resultUser;
		}
		return null;
	}
	
	/**
	 * 后台管理界面
	 */
	@RequestMapping("/admin")
	private ModelAndView admin(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("jsp/admin/admin");
		return modelAndView;
	}
	
	
	
}

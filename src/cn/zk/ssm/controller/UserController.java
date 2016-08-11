package cn.zk.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.zk.ssm.po.User;
import cn.zk.ssm.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * 更改密码
	 * @throws Exception 
	 */
	@RequestMapping(value="/updateUser")
	public @ResponseBody User updateUser(User user) throws Exception{
		String[] passwordList = user.getPassword().split(",");
		String passwordOld = passwordList[0];
		user.setPassword(passwordOld);
		User userResult = userService.selectByNameAndPassword(user);
		if(userResult!=null){//如果验证了密码正确
			String passwordNew = passwordList[1];
			user.setPassword(passwordNew);
			user.setId(userResult.getId());
			//调用dao接口更新user
			userService.updateByPrimaryKey(user);
			return user;
		}
		return null;
	}
}

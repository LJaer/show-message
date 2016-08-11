package cn.zk.ssm.service;

import cn.zk.ssm.po.User;

public interface UserService {
	//查询用户
	User selectByPrimaryKey(Integer id) throws Exception;
	User selectByNameAndPassword(User user) throws Exception;
	User selectByName(String name) throws Exception;
	//更新用户
	int updateByPrimaryKey(User record);
	
}

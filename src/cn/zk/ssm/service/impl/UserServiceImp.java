package cn.zk.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import cn.zk.ssm.mapper.UserMapperCustom;
import cn.zk.ssm.po.User;
import cn.zk.ssm.service.UserService;

public class UserServiceImp implements UserService{
	
	@Autowired
	private UserMapperCustom userMapperCustom;

	@Override
	public User selectByPrimaryKey(Integer id) throws Exception {
		return userMapperCustom.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKey(User record) {
		return userMapperCustom.updateByPrimaryKey(record);
	}

	@Override
	public User selectByNameAndPassword(User user) throws Exception {
		return userMapperCustom.selectByNameAndPassword(user);
	}

	@Override
	public User selectByName(String name) throws Exception {
		return userMapperCustom.selectByName(name);
	}
}

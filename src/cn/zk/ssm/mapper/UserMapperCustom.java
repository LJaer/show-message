package cn.zk.ssm.mapper;

import cn.zk.ssm.po.User;
import cn.zk.ssm.po.UserExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UserMapperCustom extends UserMapper{
	//根据用户名和密码查询用户
	User selectByNameAndPassword(User user);
}
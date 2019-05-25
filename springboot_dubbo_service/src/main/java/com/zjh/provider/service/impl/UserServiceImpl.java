/**
 * 
 */
package com.zjh.provider.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;
import com.zjh.dubbo.api.pojo.User;
import com.zjh.dubbo.api.service.IUserService;
import com.zjh.provider.mapper.IUserMapper;

/**
 * @author Thunisoft
 *
 */
@Service(version = "${demo.service.version}")
public class UserServiceImpl implements IUserService {
	@Autowired
	private IUserMapper userMapper;

	//查询所有的用户
	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<User> findAllUsers() {
		return userMapper.findAllUsers();
	}
	//根据用户的id 查询用户信息
	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public User findUserById(int id) {
		return userMapper.findUserById(id);
	}
	//添加用户信息
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int addUserInfo(User user) {
		return userMapper.addUserInfo(user);
	}
	//删除用户
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int removeUserInfo(int userid) {
		return userMapper.removeUserInfo(userid);
	}
	//更新用户信息
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int updateUserInfo(User user) {
		return userMapper.updateUserInfo(user);
	}

}

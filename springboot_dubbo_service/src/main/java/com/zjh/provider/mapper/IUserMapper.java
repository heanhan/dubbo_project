/**
 * 
 */
package com.zjh.provider.mapper;

import com.dubbo.api.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * @author Thunisoft
 *
 */
@Mapper
public interface IUserMapper {
	// 查询所有的用户
	public List<User> findAllUsers();

	// 根据用户姓名查询用户信息
	public User findUserById(int id);

	// 添加用户
	public int addUserInfo(User user);

	// 删除用户信息
	public int removeUserInfo(int userid);

	// 修改用户信息
	public int updateUserInfo(User user);

}

package com.skyer.mapper;

import java.util.List;

import com.skyer.vo.User;

/**
 * UserMapper接口
 * 
 * @author SKYER
 */
public interface UserMapper {

	/**
	 * 查询所有用户
	 * 
	 * @return
	 */
	public List<User> findAll();

	/**
	 * 登录检测
	 * 
	 * @param user
	 * @return
	 */
	public User login(User user);

	public List<User> findById(int id);

}

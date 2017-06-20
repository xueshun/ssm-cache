package com.skyer.service;

import java.util.List;

import com.skyer.vo.User;

/**
 * 用户服务接口
 * 
 * @author SKYER
 */
public interface UserService {

	/**
	 * 登录检测
	 * 
	 * @param user
	 * @return
	 */
	public User login(User user);

	/**
	 * 查询所有用户
	 * 
	 * @return
	 */
	public List<User> findAll();

	public List<User> findById(int id);
	
	public void removeCache();

}

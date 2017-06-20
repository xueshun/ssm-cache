package com.skyer.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.skyer.mapper.UserMapper;
import com.skyer.service.UserService;
import com.skyer.vo.User;

/**
 * 用户服务实现类
 * 
 * @author SKYER
 */
@Service
public class UserServiceImpl implements UserService {

	private static final Logger L = Logger.getLogger(UserServiceImpl.class);

	@Autowired
	private UserMapper userMapper;

	public List<User> findAll() {
		return userMapper.findAll();
	}

	@Cacheable(value = "myCache", key = "'findById'")
	public List<User> findById(int id) {
		System.out.println("*************************************************我是缓存方法*************************************************");
		List<User> list = userMapper.findById(id);
		return list;
	}

	@CacheEvict(value = "myCache", key = "'findById'")
	public void removeCache() {
		System.out.println("*************************************************移除了缓存*************************************************");
	}

	public User login(User user) {
		if (user == null) {
			System.out.println("输入的用户名或密码为空！");
			L.error("--------------------输入的用户名或密码为空！--------------------");
		}
		User temp = userMapper.login(user);
		return temp;
	}

}

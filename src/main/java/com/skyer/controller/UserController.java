package com.skyer.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skyer.service.UserService;
import com.skyer.vo.User;

/**
 * 用户控制器
 * 
 * @author SKYER
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * 查询所有用户
	 * 
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/list.do")
	@ResponseBody
	public Object list(HttpServletResponse resp) throws IOException {
		List<User> list = userService.findAll();
		return list;
	}

	@RequestMapping("/findById.do")
	@ResponseBody
	public Object findById(int id) {
		List<User> list = userService.findById(id);
		return list;
	}

	@RequestMapping("/removeCache")
	@ResponseBody
	public Object removeCache() {
		userService.removeCache();
		return "移除缓存成功！";
	}

}

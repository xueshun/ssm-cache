package com.skyer.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.skyer.service.UserService;
import com.skyer.vo.User;

/**
 * 登录控制器
 * 
 * @author SKYER
 */
@Controller
public class LoginController {

	private static final Logger L = Logger.getLogger(LoginController.class);

	@Autowired
	private UserService userService;

	/**
	 * 去到登录界面
	 * 
	 * @return
	 */
	@RequestMapping("/toLogin.do")
	public ModelAndView toLogin() {
		return new ModelAndView("login");
	}

	/**
	 * 登录操作
	 * 
	 * @param user
	 * @param session
	 * @return
	 */
	@RequestMapping("/login.do")
	public ModelAndView login(User user, HttpSession session) {
		try {
			User temp = userService.login(user);
			if (temp != null) { // 登录成功，跳转到主页面
				session.setAttribute("currentUser", temp); // 将当前用户存到session作用域
				L.info("--------------------" + temp.getName() + "登录成功--------------------");
				return new ModelAndView("index");
			} else { // 登录失败，返回到登录界面
				L.info("--------------------" + user.getName() + "登录失败（输入的用户名和密码是：" + user.getName() + ":" + user.getPwd() + "）--------------------");
				return new ModelAndView("login");
			}
		} catch (Exception e) {
			e.printStackTrace();
			L.error("------------------------", e);
		}
		return new ModelAndView("login");
	}

	/**
	 * 退出登录，去到登录界面
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping("/logout.do")
	public ModelAndView logout(HttpSession session) {
		session.removeAttribute("currentUser"); // 删除作用域当中的用户
		return new ModelAndView("login"); // 去到登录页面
	}

	/**
	 * 访问被拒绝，去到提示界面
	 * 
	 * @return
	 */
	@RequestMapping("/refuse.do")
	public ModelAndView refuse() {
		return new ModelAndView("refuse");
	}

}

package com.security.sso.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@EnableOAuth2Sso  //单点登录注解
@RestController
@RequestMapping("/user")
public class UserController {

	private final static Logger logger = LoggerFactory.getLogger(UserController.class);

	//获取当前人的认证信息
	@GetMapping("/me")
	public Object getCurrentUser(Authentication user, HttpServletRequest request){
		return user;
	}

	/*****************测试用户访问菜单权限*****************/
	@PostMapping("/menu_a")
	public String menu_a(){
		logger.info(" into '/user/menu_a' method ");
		return "this is menu_a";
	}

	@PostMapping("/menu_b")
	public String menu_b(){
		logger.info(" into '/user/menu_b' method ");
		return "this is menu_b";
	}

	@PostMapping("/menu_c")
	public String menu_c(){
		logger.info(" into '/user/menu_c' method ");
		return "this is menu_c";
	}
}

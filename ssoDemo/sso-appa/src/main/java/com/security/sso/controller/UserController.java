package com.security.sso.controller;

import com.security.sso.POJO.ReturnData;
import com.security.sso.POJO.Sys_User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

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

	/*******************************************/
	@RequestMapping("/getUserList")
	@ResponseBody
	public ReturnData<List<Sys_User>> finByIdDeclareHistory(String id) {
		try {
			ReturnData<List<Sys_User>> data = new ReturnData();
			List <Sys_User>list = new ArrayList<>();
			for(int i=0;i<=3;i++){
				Sys_User user = new Sys_User();
				user.setId(i);
				user.setPassword(i+"xxxxxx");
				user.setUsername(i+"vvvvvv");
				list.add(user);
			}
			data.setData(list);
			return data;
		} catch (Exception e) {
			return new ReturnData<List<Sys_User>>(500, "获取列表失败", null);
		}
	}
}

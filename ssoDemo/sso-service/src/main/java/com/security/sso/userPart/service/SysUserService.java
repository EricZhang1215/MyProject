package com.security.sso.userPart.service;

import com.security.sso.userPart.entity.Sys_User;

public interface SysUserService {

	Sys_User selectById(int id);

	Sys_User selectByUsername(String username);
}

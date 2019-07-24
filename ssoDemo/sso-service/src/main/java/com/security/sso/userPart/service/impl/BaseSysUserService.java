package com.security.sso.userPart.service.impl;

import com.security.sso.userPart.entity.Sys_User;
import com.security.sso.userPart.mapper.SysUserMapper;
import com.security.sso.userPart.service.SysUserService;
import lombok.extern.log4j.Log4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
@Log4j
public class BaseSysUserService implements SysUserService {

	private final SysUserMapper sysUserMapper;

	public BaseSysUserService(SysUserMapper sysUserMapper){
		this.sysUserMapper = sysUserMapper;
	}

	@Override
	public Sys_User selectById(int id) {
		return sysUserMapper.selectById(id);
	}

	@Override
	public Sys_User selectByUsername(String username) {
		return sysUserMapper.selectByUsername(username);
	}
}

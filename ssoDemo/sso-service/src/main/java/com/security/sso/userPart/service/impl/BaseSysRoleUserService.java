package com.security.sso.userPart.service.impl;

import com.security.sso.userPart.entity.Sys_Role_User;
import com.security.sso.userPart.mapper.SysRoleUserMapper;
import com.security.sso.userPart.service.SysRoleUserService;
import lombok.extern.log4j.Log4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@Log4j
public class BaseSysRoleUserService implements SysRoleUserService {

	private final SysRoleUserMapper SysRoleUserMapper;

	public BaseSysRoleUserService(SysRoleUserMapper SysRoleUserMapper){
		this.SysRoleUserMapper = SysRoleUserMapper;
	}


	@Override
	public List<Sys_Role_User> selectByUser_id(int user_id) {
		return SysRoleUserMapper.selectByUser_id(user_id);
	}
}

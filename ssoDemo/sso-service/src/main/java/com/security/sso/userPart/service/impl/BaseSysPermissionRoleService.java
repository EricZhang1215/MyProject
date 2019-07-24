package com.security.sso.userPart.service.impl;

import com.security.sso.userPart.entity.Sys_Permission_Role;
import com.security.sso.userPart.mapper.SysPermissionRoleMapper;
import com.security.sso.userPart.service.SysPermissionRoleService;
import lombok.extern.log4j.Log4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@Log4j
public class BaseSysPermissionRoleService implements SysPermissionRoleService {

	private final SysPermissionRoleMapper SysPermissionRoleMapper;

	public BaseSysPermissionRoleService(SysPermissionRoleMapper SysPermissionRoleMapper){
		this.SysPermissionRoleMapper = SysPermissionRoleMapper;
	}
	public List<Sys_Permission_Role> selectPermissionRole(int role_id){
		return SysPermissionRoleMapper.selectPermissionRole(role_id);
	}
}

package com.favccxx.security.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.favccxx.security.domain.SysResource;
import com.favccxx.security.domain.SysRole;
import com.favccxx.security.exception.AppException;

public interface RoleService {

	/**
	 * 创建或更新角色
	 * @param sysRole
	 */
	void saveRole(SysRole sysRole);
	
	
	/**
	 * 分页查询角色列表
	 * @param roleCode
	 * @param roleName
	 * @param pageable
	 * @return
	 */
	Page<SysRole> pageRoles(String roleCode, String roleName, Pageable pageable);
	
	/**
	 * 根据角色Id查询权限列表
	 * @param roleId
	 * @return
	 */
	List<SysResource> listByRoleId(long roleId);
	
	
	void updateRoleResources(long roleId, List<SysResource> addResources, List<SysResource> removeResources) throws AppException;
	
}

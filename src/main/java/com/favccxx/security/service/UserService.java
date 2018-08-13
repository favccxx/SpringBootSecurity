package com.favccxx.security.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.favccxx.security.domain.SysUser;

public interface UserService {
	
	/**
	 * 保存用户
	 * @param sysUser
	 */
	void saveUser(SysUser sysUser);
	
	/**
	 * 根据用户名查找用户不区分大小写
	 * @param username
	 * @return
	 */
	SysUser findByUsername(String username);
	
	/**
	 * 分页查询用户列表
	 * @param username
	 * @param pageable
	 * @return
	 */
	Page<SysUser> pageUsers(String username, Pageable pageable);

}

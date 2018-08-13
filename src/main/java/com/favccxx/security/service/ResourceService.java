package com.favccxx.security.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.favccxx.security.domain.SysResource;

public interface ResourceService {

	/**
	 * 根据Id查找权限资源
	 * @param id
	 * @return
	 */
	SysResource findById(long id);
	
	/**
	 * 创建或更新权限
	 * @param sysResource
	 */
	void saveResource(SysResource sysResource);
	
	
	/**
	 * 分页查询权限列表
	 * @param roleCode
	 * @param roleName
	 * @param pageable
	 * @return
	 */
	Page<SysResource> pageResources(String resourceCode, String resourceName, Pageable pageable);
	
	/**
	 * 仅查询状态有效的权限
	 * @param resourceCode
	 * @param resourceName
	 * @param pageable
	 * @return
	 */
	Page<SysResource> pageValidResources(String resourceCode, String resourceName, Pageable pageable);
}

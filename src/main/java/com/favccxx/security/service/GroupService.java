package com.favccxx.security.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.favccxx.security.domain.SysGroup;

public interface GroupService {
	
	void saveGroup(SysGroup sysGroup);
	
	
	SysGroup findById(Long id);
	
	
	SysGroup findByGroupCode(String groupCode);
	
	
	/**
	 * 根据用户组代码或名称分页查询用户组列表
	 * @param searchTxt
	 * @param pageable
	 * @return
	 */
	Page<SysGroup> pageGroups(String searchTxt, Pageable pageable);
	
	/**
	 * 根据用户组Id删除用户组
	 * @param Id
	 */
	void deleteByGroupId(long Id);

}

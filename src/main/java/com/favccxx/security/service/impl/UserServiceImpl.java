package com.favccxx.security.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.favccxx.security.domain.SysRole;
import com.favccxx.security.domain.SysUser;
import com.favccxx.security.domain.SysGroup;
import com.favccxx.security.repository.SuperUserRepository;
import com.favccxx.security.service.UserService;

@Service
public class UserServiceImpl implements UserDetailsService, UserService {
	
	@Autowired
	SuperUserRepository userRepository;

	@Override
	public SysUser findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		SysUser user = userRepository.findByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException(username + "不存在！");
		}
		
		Set<SysGroup> userGroups = user.getGroups();
		for(SysGroup userGroup : userGroups) {
			Set<SysRole> roles = userGroup.getRoles();
//			user.setRoles(roles);
		}
		return user;
	}

	@Override
	public Page<SysUser> pageUsers(String username, Pageable pageable) {
		return userRepository.pageUsers(pageable);
	}

	@Override
	public void saveUser(SysUser sysUser) {
		userRepository.save(sysUser);
	}

}

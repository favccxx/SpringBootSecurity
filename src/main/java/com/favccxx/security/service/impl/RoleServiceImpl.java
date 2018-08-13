package com.favccxx.security.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.favccxx.security.domain.SysResource;
import com.favccxx.security.domain.SysRole;
import com.favccxx.security.exception.AppException;
import com.favccxx.security.repository.SysRoleRepository;
import com.favccxx.security.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	SysRoleRepository roleRepository;

	@Override
	public void saveRole(SysRole sysRole) {
		roleRepository.save(sysRole);
	}

	@Override
	public Page<SysRole> pageRoles(String roleCode, String roleName, Pageable pageable) {
		if (StringUtils.isBlank(roleCode)) {
			roleCode = "%%";
		} else {
			roleCode = "%" + roleCode + "%";
		}

		if (StringUtils.isBlank(roleName)) {
			roleName = "%%";
		} else {
			roleName = "%" + roleName + "%";
		}
		return roleRepository.pageUsers(roleCode, roleName, pageable);
	}

	@Override
	public List<SysResource> listByRoleId(long roleId) {
		Optional<SysRole> opt = roleRepository.findById(roleId);
		if (opt != null && opt.get() != null) {
			SysRole role = opt.get();
//			return role.getResources();
		}
		return null;
	}


	@Override
	public void updateRoleResources(long roleId, List<SysResource> addResources, List<SysResource> removeResources)
			throws AppException {
		Optional<SysRole> opt = roleRepository.findById(roleId);
		if (opt != null && opt.get() != null) {
			SysRole role = opt.get();
			
//			role.getResourceList().removeAll(removeResources);
//			role.getResourceList().removeAll(addResources);
//			role.getResourceList().addAll(addResources);
			
			roleRepository.save(role);
		}
	}

}

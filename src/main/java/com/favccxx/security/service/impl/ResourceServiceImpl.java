package com.favccxx.security.service.impl;

import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.favccxx.security.domain.SysResource;
import com.favccxx.security.repository.SysResourceRepository;
import com.favccxx.security.service.ResourceService;

@Service
public class ResourceServiceImpl implements ResourceService {

	@Autowired
	SysResourceRepository resourceRepository;
	
	@Override
	public SysResource findById(long id) {
		Optional<SysResource> opt = resourceRepository.findById(id);		
		return opt.get();
	}
	
	@Override
	public void saveResource(SysResource sysResource) {
		resourceRepository.save(sysResource);
	}

	@Override
	public Page<SysResource> pageResources(String resourceCode, String resourceName, Pageable pageable) {
		if(StringUtils.isBlank(resourceCode)) {
			resourceCode = "%%";
		}else {
			resourceCode = "%" + resourceCode + "%";
		}
		
		if(StringUtils.isBlank(resourceName)) {
			resourceName = "%%";
		}else {
			resourceName = "%" + resourceName + "%";
		}
		return resourceRepository.pageResources(resourceCode, resourceName, pageable);
	}

	@Override
	public Page<SysResource> pageValidResources(String resourceCode, String resourceName, Pageable pageable) {
		if(StringUtils.isBlank(resourceCode)) {
			resourceCode = "%%";
		}else {
			resourceCode = "%" + resourceCode + "%";
		}
		
		if(StringUtils.isBlank(resourceName)) {
			resourceName = "%%";
		}else {
			resourceName = "%" + resourceName + "%";
		}
		return resourceRepository.pageResources(resourceCode, resourceName, pageable);
	}

	

}

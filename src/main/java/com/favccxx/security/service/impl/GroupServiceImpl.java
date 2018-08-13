package com.favccxx.security.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.favccxx.security.domain.SysGroup;
import com.favccxx.security.repository.SysGroupRepository;
import com.favccxx.security.service.GroupService;

@Service
public class GroupServiceImpl implements GroupService {
	
	@Autowired
	SysGroupRepository groupRepository;


	@Override
	public void saveGroup(SysGroup sysGroup) {
		groupRepository.save(sysGroup);
	}

	@Override
	public SysGroup findById(Long id) {
		Optional<SysGroup> opt = groupRepository.findById(id);
		return opt.get();
	}

	@Override
	public SysGroup findByGroupCode(String groupCode) {
		return groupRepository.findByGroupCode(groupCode);
	}

	@Override
	public Page<SysGroup> pageGroups(String searchTxt, Pageable pageable) {
		return groupRepository.pageGroups(searchTxt, pageable);
	}

	@Override
	public void deleteByGroupId(long id) {
		groupRepository.deleteById(id);
	}

}

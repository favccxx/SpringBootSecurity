package com.favccxx.security.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.favccxx.security.domain.SysGroup;

public interface SysGroupRepository extends JpaRepository<SysGroup, Long> {
	
	SysGroup findByGroupCode(String groupCode);
	
	
	
	@Query(value = "from SysGroup sg where sg.groupCode like ?1 or sg.groupName like ?1", countQuery = " select count(sg) from SysGroup sg where sg.groupCode like ?1 or sg.groupName like ?1")
	Page<SysGroup> pageGroups(String searchTxt, Pageable pageable);

}

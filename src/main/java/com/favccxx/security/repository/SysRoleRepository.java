package com.favccxx.security.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.favccxx.security.domain.SysRole;

public interface SysRoleRepository extends JpaRepository<SysRole, Long> {

	@Query(value = "from SysRole sr where roleCode like ?1 or roleName like ?2", countQuery = " select count(sr) from SysRole sr where sr.roleCode like ?1 or sr.roleName like ?2")
	Page<SysRole> pageUsers(String roleCode, String roleName, Pageable pageable);

	
}

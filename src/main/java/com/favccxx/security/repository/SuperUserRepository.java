package com.favccxx.security.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.favccxx.security.domain.SysUser;

public interface SuperUserRepository extends JpaRepository<SysUser, Long>{
	
	SysUser findByUsername(String username);
	
	
	@Query(value = "from SysUser su", countQuery = " select count(su) from SysUser su")
	Page<SysUser> pageUsers(Pageable pageable);

}

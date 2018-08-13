package com.favccxx.security.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.favccxx.security.domain.SysResource;

public interface SysResourceRepository extends JpaRepository<SysResource, Long> {

	@Query(value = "from SysResource sr where resourceCode like ?1 or resourceName like ?2", countQuery = " select count(sr) from SysResource sr where sr.resourceCode like ?1 or sr.resourceName like ?2")
	Page<SysResource> pageResources(String resourceCode, String resourceName, Pageable pageable);

	
	@Query(value = "from SysResource sr where sr.disabled=false and (sr.resourceCode like ?1 or sr.resourceName like ?2)", countQuery = " select count(sr) from SysResource sr where sr.disabled=false and (sr.resourceCode like ?1 or sr.resourceName like ?2)")
	Page<SysResource> pageValidResources(String resourceCode, String resourceName, Pageable pageable);
}

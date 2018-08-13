package com.favccxx.security.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.favccxx.security.domain.SysResource;
import com.favccxx.security.domain.SysRole;
import com.favccxx.security.exception.AppException;
import com.favccxx.security.service.ResourceService;
import com.favccxx.security.service.RoleService;
import com.favccxx.security.utils.DataTables;

@Controller
@RolesAllowed(value="admin")
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
	RoleService roleService;
	@Autowired
	ResourceService resourceService;
	

	@RequestMapping("/list")
	public String list(Model model) {
		return "role/list";
	}
	
	@RequestMapping("/pageRoles")
	@ResponseBody
	public DataTables<SysRole> pageRoles(
			@RequestParam(value = "draw",required = true) Integer draw,
            @RequestParam(value = "start",defaultValue = "0") Integer start,
            @RequestParam(value = "length",defaultValue = "10") Integer length,
            @RequestParam(value = "searchTxt",required = false) String searchTxt) {
		DataTables<SysRole> dataTables = new DataTables<SysRole>();
		
		Sort sort = new Sort(Direction.ASC, "roleId");
		Pageable pageable = PageRequest.of(start, length, sort);
		
		Page<SysRole> pageRole = roleService.pageRoles(searchTxt, searchTxt, pageable);
		
		dataTables.setData(pageRole.getContent());
		dataTables.setDraw(draw);
		dataTables.setRecordsTotal(pageRole.getTotalElements());
		
		return dataTables;
	}
	
	
	@RequestMapping("/authorize")
	public String authorize(Model model) {
		return "role/authorize";
	}
	
	
	
	
	
	@RequestMapping(value = "/updateAuthorize", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String updateAuthorize(HttpSession session, @RequestBody String params) throws NumberFormatException, AppException {
		Map<String, Object> dataMap = (Map<String, Object>) JSON.parse(params);
		
		Integer roleId = (Integer) dataMap.get("roleId");
		String selectedMenuIds = (String) dataMap.get("selectedMenuIds");
		String removeMenuIds = (String) dataMap.get("removeMenuIds");
		
		
		List<SysResource> addResources = new ArrayList<SysResource>();
		List<SysResource> removeResources = new ArrayList<SysResource>();
		
		if(roleId != 0) {
			//
		}
		
		if(!StringUtils.isBlank(selectedMenuIds)) {
			String[] addIds = selectedMenuIds.split(",");
			for(String resourceId : addIds) {
				if(!StringUtils.isBlank(resourceId)) {
					SysResource resource = resourceService.findById(Long.valueOf(resourceId));
					addResources.add(resource);
				}
			}
		}
		
		if(!StringUtils.isBlank(removeMenuIds)) {
			String[] resourceIds = removeMenuIds.split(",");
			for(String resourceId : resourceIds) {
				if(!StringUtils.isBlank(resourceId)) {
					SysResource resource = resourceService.findById(Long.valueOf(resourceId));
					removeResources.add(resource);
				}
			}
		}
		
		roleService.updateRoleResources(Long.valueOf(roleId), addResources, removeResources);

		return JSON.toJSONString("success");
	}
	
	
	
	@RequestMapping("/pageResourcesByRoleId")
	@ResponseBody
	public String pageResourcesByRoleId(long roleId) {
		List<SysResource> resourceList = roleService.listByRoleId(roleId);
		return JSON.toJSONString(resourceList);
	}

}

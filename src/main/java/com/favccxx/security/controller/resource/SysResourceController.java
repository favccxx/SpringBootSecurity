package com.favccxx.security.controller.resource;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.favccxx.security.domain.SysResource;
import com.favccxx.security.service.ResourceService;
import com.favccxx.security.utils.DataTables;

@Controller
@RolesAllowed(value="admin")
@RequestMapping("/resource")
public class SysResourceController {

	
	@Autowired
	ResourceService resourceService;
	

	@RequestMapping("/list")
	public String list(Model model) {
		return "resource/list";
	}
	
	@RequestMapping("/pageResources")
	@ResponseBody
	public DataTables<SysResource> pageResources(
			@RequestParam(value = "draw",required = true) Integer draw,
            @RequestParam(value = "start",defaultValue = "0") Integer start,
            @RequestParam(value = "length",defaultValue = "10") Integer length,
            @RequestParam(value = "searchTxt",required = false) String searchTxt) {
		DataTables<SysResource> dataTables = new DataTables<SysResource>();
		
		Sort sort = new Sort(Direction.ASC, "resourceId");
		Pageable pageable = PageRequest.of(start, length, sort);
		
		Page<SysResource> pageRole = resourceService.pageResources(searchTxt, searchTxt, pageable);
		
		dataTables.setData(pageRole.getContent());
		dataTables.setDraw(draw);
		dataTables.setRecordsTotal(pageRole.getTotalElements());
		
		return dataTables;
	}
	
	
	@RequestMapping("/pageRoleResources")
	@ResponseBody
	public DataTables<SysResource> pageRoleResources(
			@RequestParam(value = "draw",required = true) Integer draw,
            @RequestParam(value = "start",defaultValue = "0") Integer start,
            @RequestParam(value = "length",defaultValue = "10") Integer length,
            @RequestParam(value = "searchTxt",required = false) String searchTxt) {
		DataTables<SysResource> dataTables = new DataTables<SysResource>();
		
		Sort sort = new Sort(Direction.ASC, "resourceId");
		Pageable pageable = PageRequest.of(start, length, sort);
		
		Page<SysResource> pageRole = resourceService.pageValidResources(searchTxt, searchTxt, pageable);
		
		dataTables.setData(pageRole.getContent());
		dataTables.setDraw(draw);
		dataTables.setRecordsTotal(pageRole.getTotalElements());
		
		return dataTables;
	}
	
	
	@RequestMapping("/saveResource")
	@ResponseBody
	public String saveResource(HttpSession session, @ModelAttribute("sysResource") SysResource sysResource) {
		
		resourceService.saveResource(sysResource);

		return "success";
	}
	
}

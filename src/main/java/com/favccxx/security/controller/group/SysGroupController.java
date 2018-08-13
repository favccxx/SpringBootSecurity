package com.favccxx.security.controller.group;

import java.security.Principal;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.favccxx.security.domain.SysGroup;
import com.favccxx.security.service.GroupService;
import com.favccxx.security.utils.DataTables;
import com.favccxx.security.utils.RestResult;
import com.favccxx.security.utils.datatable.DataTableRequest;

@Controller
@RequestMapping("/group")
public class SysGroupController {

	@Autowired
	GroupService groupService;

	@RequestMapping("/list")
	public String list(Model model) {
		return "group/list";
	}

	@RequestMapping(value = "/pageGroups")
	@ResponseBody
	public DataTables<SysGroup> pageGroups(HttpServletRequest request) {
		DataTableRequest input = new DataTableRequest(request);
		DataTables<SysGroup> dataTables = new DataTables<SysGroup>();

		String searchValue = input.getSearch().getValue();
		if (StringUtils.isBlank(searchValue)) {
			searchValue = "%%";
		}else {
			searchValue = "%" + searchValue + "%";
		}

		Sort sort = new Sort(Direction.ASC, "groupId");
		if (input.getOrder() != null) {
			if ("asc".equals(input.getOrder().getSortDir())) {
				sort = new Sort(Direction.ASC, input.getOrder().getData());
			} else {
				sort = new Sort(Direction.DESC, input.getOrder().getData());
			}
		}
		Pageable pageable = PageRequest.of(input.getStart(), input.getLength(), sort);

		Page<SysGroup> pageGroup = groupService.pageGroups(searchValue, pageable);

		dataTables.setData(pageGroup.getContent());
		dataTables.setDraw(input.getDraw());
		dataTables.setRecordsTotal(pageGroup.getTotalElements());

		return dataTables;
	}

	@RequestMapping(value = "/saveGroup")
	@ResponseBody
	public String saveGroup(Principal principal, @ModelAttribute("sysGroup") SysGroup sysGroup) {

		sysGroup.setCreateUsername(principal.getName());
		sysGroup.setCreateTime(new Date());
		sysGroup.setUpdateUsername(principal.getName());
		sysGroup.setUpdateTime(new Date());
		groupService.saveGroup(sysGroup);

		// int RestResult;
		return RestResult.success(sysGroup);

	}
}

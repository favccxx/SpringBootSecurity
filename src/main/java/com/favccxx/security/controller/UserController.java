package com.favccxx.security.controller;

import java.util.Map;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.favccxx.security.domain.SysUser;
import com.favccxx.security.service.UserService;
import com.favccxx.security.utils.DataTables;
import com.favccxx.security.utils.RestResult;

@Controller
@RolesAllowed(value="admin")
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping("/list")
	public String list(Model model) {
		return "user/list";
	}
	
	@RequestMapping("/pageUsers")
	@ResponseBody
	public DataTables<SysUser> pageUsers(
			@RequestParam(value = "draw",required = true) Integer draw,
            @RequestParam(value = "start",defaultValue = "0") Integer start,
            @RequestParam(value = "length",defaultValue = "10") Integer length,
            @RequestParam(value = "username",required = false) String username) {
		DataTables<SysUser> dataTables = new DataTables<SysUser>();
		
		Sort sort = new Sort(Direction.DESC, "userId");
		Pageable pageable = PageRequest.of(start, length, sort);
		Page<SysUser> pageUser = userService.pageUsers("%", pageable);
		
		dataTables.setData(pageUser.getContent());
		dataTables.setDraw(draw);
		dataTables.setRecordsTotal(pageUser.getTotalElements());
		
		return dataTables;
	}
	
	
	@RequestMapping(value = "/saveUser", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String saveUser( @RequestBody String params) {
		Map<String, Object> dataMap = (Map<String, Object>) JSON.parse(params);
		
		String username = (String) dataMap.get("username");
		String password = (String) dataMap.get("password");
		
//		SysUser sysUser = JSON.parseObject(jsonBody, SysUser.class);
//		if(sysUser.getUserId()==0) {
		SysUser sysUser = new SysUser();
		sysUser.setUsername(username);
			BCryptPasswordEncoder bpe = new BCryptPasswordEncoder();
			String encryptPwd = bpe.encode(password);
			sysUser.setPassword(encryptPwd);
			userService.saveUser(sysUser);
//		}
		
		return RestResult.success(sysUser);
	}

	

}

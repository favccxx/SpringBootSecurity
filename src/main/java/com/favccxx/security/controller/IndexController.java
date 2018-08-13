package com.favccxx.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.favccxx.security.domain.SuperMessage;

@Controller
public class IndexController {

	@RequestMapping(value= {"/", "/index"})
	public String index(Model model) {
		SuperMessage msg = new SuperMessage("标题", "内容", "备注");
		model.addAttribute("msg", msg);
		return "home";
	}
	
	
}

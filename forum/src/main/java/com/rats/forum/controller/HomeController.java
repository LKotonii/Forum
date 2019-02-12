package com.rats.forum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/home-page")
	public String sayhello(Model theModel) {
		theModel.addAttribute("theDate", new java.util.Date());
		return "home-page";
	}

}

package com.cos.blog.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {
	
	// 컨트롤로에서 세션을 어떻게 찾는지?
	// @AuthenticationPrincipal PrincipalDetail principal
	@GetMapping({"", "/"})
	public String index() {
		return "index"; // viewResolver 작동!!
	}

}

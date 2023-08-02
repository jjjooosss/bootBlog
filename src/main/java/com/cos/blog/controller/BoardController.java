package com.cos.blog.controller;

import com.cos.blog.config.auth.PrincipalDetail;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {
	
	// 컨트롤러에서 세션을 어떻게 찾는지?(내가 만든 세션이 아니니까)
	// @AuthenticationPrincipal PrincipalDetail principal
	@GetMapping({"", "/"})
//	public String index(@AuthenticationPrincipal PrincipalDetail principal) {
	public String index() {
//		System.out.println("로그인 사용자 아이디 = " + principal.getUsername());
		return "index"; // viewResolver 작동!!
	}

}

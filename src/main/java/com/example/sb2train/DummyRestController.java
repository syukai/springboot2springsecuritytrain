package com.example.sb2train;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class DummyRestController {

	@GetMapping("success")
	public String succcess() {
		return "success";
	}
	
	@GetMapping("failure")
	public String failure() {
		return "failure";
	}
}

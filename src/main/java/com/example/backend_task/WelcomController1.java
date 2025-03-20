package com.example.backend_task;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomController1 {
	
	@GetMapping("/welcome")
	public String welcome() {
		return "Hello Lilani";
	}

}

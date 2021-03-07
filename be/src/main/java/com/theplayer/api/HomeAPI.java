package com.theplayer.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/home")
public class HomeAPI {
	
	@GetMapping
	public ResponseEntity<String> getMethodName() {
		return ResponseEntity.ok("Home");
	}

}

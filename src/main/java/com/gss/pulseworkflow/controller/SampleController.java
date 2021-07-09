package com.gss.pulseworkflow.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/sample")

public class SampleController {

	// Logger logger = LoggerFactory.getLogger(UserController.class);

	/*
	 * 
	 * @Autowired private UserRepository userRepository;
	 * 
	 */

	/**
	 * 
	 * Get all users list.
	 *
	 * 
	 * 
	 * @return the list
	 * 
	 */

	@GetMapping("/test/{userId}")

	public String getAllUsers(@PathVariable(value = "userId") String userId) {

		// busiesss logic

		System.out.println("user Id ::" + userId);

		return null;

	}

}

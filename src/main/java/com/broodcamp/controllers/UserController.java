package com.broodcamp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Edward P. Legaspi
 */
@RestController
@RequestMapping("/users")
//@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
public class UserController {

	@GetMapping(path = "")
	public String index() {
		return "Users";
	}

}

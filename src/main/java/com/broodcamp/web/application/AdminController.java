package com.broodcamp.web.application;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Edward P. Legaspi
 */
@RestController
@RequestMapping(path = "/v1/admin")
//@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

	@GetMapping(path = "")
	public String index() {
		return "Admin";
	}

}

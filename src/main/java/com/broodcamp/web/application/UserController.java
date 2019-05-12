package com.broodcamp.web.application;

import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.broodcamp.utils.SecurityContextUtils;

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

	@GetMapping(path = "/user")
	@PreAuthorize("hasAnyAuthority('USER')")
	public ResponseEntity<String> getAuthorizedUserName() {
		return ResponseEntity.ok(SecurityContextUtils.getUserName());
	}

	@GetMapping(path = "/roles")
	@PreAuthorize("hasAnyAuthority('USER')")
	public ResponseEntity<Set<String>> getAuthorizedUserRoles() {
		return ResponseEntity.ok(SecurityContextUtils.getUserRoles());
	}

}

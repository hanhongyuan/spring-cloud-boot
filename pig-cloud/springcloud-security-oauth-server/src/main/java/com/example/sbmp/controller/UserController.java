package com.example.sbmp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserController {
	@RequestMapping("/user")
	public Principal user(Principal user) {
		System.out.println("FFFFFFFFFFFFFFFFF" +user);
		return user;
	}

}

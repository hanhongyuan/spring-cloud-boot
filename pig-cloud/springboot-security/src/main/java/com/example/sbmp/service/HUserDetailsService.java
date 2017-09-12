package com.example.sbmp.service;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * 获取用户
 */
public interface HUserDetailsService {
	/**
	 * 通过用户名获取用户
	 * 
	 * @param userName
	 * @return
	 */
	public UserDetails loadUserByUsername(String userName);
}

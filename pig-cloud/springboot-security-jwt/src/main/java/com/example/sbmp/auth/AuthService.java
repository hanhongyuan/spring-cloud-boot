package com.example.sbmp.auth;

import com.example.sbmp.user.User;

public interface AuthService {
	User register(User userToAdd);

	/**
	 * 通过用户名密码登陆获取token
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	String login(String username, String password);

	String refresh(String oldToken);
}

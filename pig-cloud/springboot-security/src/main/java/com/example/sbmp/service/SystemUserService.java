package com.example.sbmp.service;

import com.example.sbmp.model.SystemUserEntity;

public interface SystemUserService {

	/**
	 * 通过用户名找到用户
	 */
	SystemUserEntity findByName(String userName);

}

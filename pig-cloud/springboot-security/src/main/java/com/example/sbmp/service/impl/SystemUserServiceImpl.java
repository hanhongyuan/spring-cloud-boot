package com.example.sbmp.service.impl;

import org.springframework.stereotype.Service;

import com.example.sbmp.model.SystemUserEntity;
import com.example.sbmp.service.SystemUserService;

@Service
public class SystemUserServiceImpl implements SystemUserService {

	@Override
	public SystemUserEntity findByName(String userName) {
		SystemUserEntity entity = new SystemUserEntity();
		entity.setUserName(userName);
		entity.setPassword("admin");
		// TODO Auto-generated method stub
		return entity;
	}

}

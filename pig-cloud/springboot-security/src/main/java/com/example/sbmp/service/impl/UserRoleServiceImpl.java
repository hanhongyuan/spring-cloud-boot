package com.example.sbmp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.sbmp.model.SystemUserEntity;
import com.example.sbmp.model.UserRoleEntity;
import com.example.sbmp.service.UserRoleService;
@Service
public class UserRoleServiceImpl implements UserRoleService {

	@Override
	public List<UserRoleEntity> getRoleByUser(SystemUserEntity user) {
		List<UserRoleEntity> list = new ArrayList<UserRoleEntity>();
		// TODO Auto-generated method stub
		return list;
	}

}

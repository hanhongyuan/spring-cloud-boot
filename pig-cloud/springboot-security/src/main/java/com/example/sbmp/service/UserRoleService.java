package com.example.sbmp.service;

import java.util.List;

import com.example.sbmp.model.SystemUserEntity;
import com.example.sbmp.model.UserRoleEntity;

/**
 * 用户角色服务
 */
public interface UserRoleService {

	/**
	 * 通过用户找到角色
	 * 
	 * @param user
	 * @return
	 */
	List<UserRoleEntity> getRoleByUser(SystemUserEntity user);

}

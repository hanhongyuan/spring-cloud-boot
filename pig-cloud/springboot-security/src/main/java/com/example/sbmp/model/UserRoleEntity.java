package com.example.sbmp.model;

import org.springframework.security.core.GrantedAuthority;

/**
 * 用户的角色
 *
 */
public class UserRoleEntity implements GrantedAuthority{
	private static final long serialVersionUID = 1L;

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return null;
	}

}

package com.example.sbmp.config;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.sbmp.model.SystemUserEntity;
import com.example.sbmp.model.UserRoleEntity;

public class MyUserDetails implements UserDetails {
	private static final long serialVersionUID = 1L;
	private SystemUserEntity user;
	private List<UserRoleEntity> roles;

	private String password;
	private String username;
	public MyUserDetails(SystemUserEntity user, List<UserRoleEntity> roles) {
		super();
		this.setUser(user);
		this.password = user.getPassword();
		this.setRoles(roles);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	public SystemUserEntity getUser() {
		return user;
	}

	public void setUser(SystemUserEntity user) {
		this.user = user;
	}

	public List<UserRoleEntity> getRoles() {
		return roles;
	}

	public void setRoles(List<UserRoleEntity> roles) {
		this.roles = roles;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}

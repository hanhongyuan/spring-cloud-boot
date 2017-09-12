package com.example.sbmp.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsEntity implements UserDetails {
	private static final long serialVersionUID = 1L;
	
	private Collection<? extends GrantedAuthority> roles;
	private SystemUserEntity user;
	//private List<UserRoleEntity> roles;

	private String password;
	private String username;
	public UserDetailsEntity(SystemUserEntity user,Collection<? extends GrantedAuthority> roles) {
		super();
		this.setUser(user);
		this.password = user.getPassword();
		this.setRoles(roles);
	}

	/**
	 * 返回给用户的权限。不能返回零
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles;
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

	/**
	 * 表示用户的帐户是否已过期。过期的帐户不能认证
	 */
	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	/**
	 * 表示用户是锁定还是解锁。无法通过身份验证的用户
	 */
	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	/**
	 * 表示用户的凭据(密码)是否已过期。过期的证书防止身份验证。
	 */
	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	/**
	 * 表示用户是否启用或禁用。不能通过身份验证的用户。
	 */
	@Override
	public boolean isEnabled() {
		return false;
	}

	public SystemUserEntity getUser() {
		return user;
	}

	public void setUser(SystemUserEntity user) {
		this.user = user;
	}

	public Collection<? extends GrantedAuthority> getRoles() {
		return roles;
	}

	public void setRoles(Collection<? extends GrantedAuthority> roles) {
		this.roles = roles;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}

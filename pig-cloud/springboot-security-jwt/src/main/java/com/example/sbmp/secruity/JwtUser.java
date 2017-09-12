package com.example.sbmp.secruity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;

/**
 *用户实体
 */
public class JwtUser implements UserDetails {
	private static final long serialVersionUID = 1L;
	private final String id;
    private final String username;
    private final String password;
    private final String email;
    private final Collection<? extends GrantedAuthority> authorities;
    private final Date lastPasswordResetDate;
    private Boolean accountNonLocked = false;
    private Boolean credentialsNonExpired = false;
    private Boolean enabled = false;
    public JwtUser(
            String id,
            String username,
            String password,
            String email,
            Collection<? extends GrantedAuthority> authorities,
            Date lastPasswordResetDate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.authorities = authorities;
        this.lastPasswordResetDate = lastPasswordResetDate;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @JsonIgnore
    public String getId() {
        return id;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    /**
	 * 表示用户是锁定还是解锁。无法通过身份验证的用户
	 */
    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }
    public void setAccountNonLocked(Boolean accountNonLocked) {
    	this.accountNonLocked = accountNonLocked;
    }
    
    /**
	 * 表示用户的凭据(密码)是否已过期。过期的证书防止身份验证。
	 */
    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }
    public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
    	this.credentialsNonExpired = credentialsNonExpired;
    }
    /**
	 * 表示用户是否启用或禁用。不能通过身份验证的用户。
	 */
    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return enabled;
    }
    public void setEnabled(Boolean enabled) {
    	this.enabled = enabled;
    }
    @JsonIgnore
    public Date getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }

	public String getEmail() {
		return email;
	}
}

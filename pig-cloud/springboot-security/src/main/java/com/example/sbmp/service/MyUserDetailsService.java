package com.example.sbmp.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.sbmp.model.SystemUserEntity;
import com.example.sbmp.model.UserDetailsEntity;
import com.example.sbmp.model.UserRoleEntity;

@Service
public class MyUserDetailsService implements UserDetailsService {
	@Resource
    private SystemUserService systemUserService;

    @Resource
    private UserRoleService userRoleService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        SystemUserEntity user;
        try {
            user = systemUserService.findByName(userName);
        } catch (Exception e) {
            throw new UsernameNotFoundException("user select fail");
        }
        if(user == null){
            throw new UsernameNotFoundException("no user found");
        } else {
            try {
                List<UserRoleEntity> roles = userRoleService.getRoleByUser(user);
                return new UserDetailsEntity(user, roles);
            } catch (Exception e) {
                throw new UsernameNotFoundException("user role select fail");
            }
        }
    }
}

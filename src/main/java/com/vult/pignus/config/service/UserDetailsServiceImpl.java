package com.vult.pignus.config.service;


import com.vult.pignus.entity.SysPermission;
import com.vult.pignus.entity.SysUser;
import com.vult.pignus.service.SysPermissionService;
import com.vult.pignus.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysPermissionService sysPermissionService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username == null || username.equals(""))
            throw new RuntimeException("Username can not be blank");
        SysUser sysUser = sysUserService.queryByAccount(username);
        if (sysUser == null)
            throw new RuntimeException("User not exist");
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        List<SysPermission> permissions = sysPermissionService.selectListByUser(sysUser.getId());
        for (SysPermission permission :
                permissions) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getPermissionCode());
            grantedAuthorities.add(grantedAuthority);
        }
        return new User(sysUser.getAccount(), sysUser.getPassword(), sysUser.getEnabled(),
                sysUser.getAccountNotExpired(),sysUser.getCredentialsNotExpired(),
                sysUser.getAccountNotLocked(), grantedAuthorities);
    }
}

package com.vult.pignus.config.handler;

import com.vult.pignus.entity.SysPermission;
import com.vult.pignus.service.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

@Component
public class CustomizeFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Autowired
    private SysPermissionService sysPermissionService;

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        String requestURL = ((FilterInvocation) o).getRequestUrl();
        List<SysPermission> permissions = sysPermissionService.selectListByPath(requestURL);
        if (permissions == null || permissions.size() == 0)
            return null;
        String[] attributes = new String[permissions.size()];
        for (int i=0; i<permissions.size();i++)
            attributes[i] = permissions.get(i).getPermissionCode();
        return SecurityConfig.createList(attributes);
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}

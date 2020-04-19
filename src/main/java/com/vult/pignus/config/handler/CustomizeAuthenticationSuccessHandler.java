package com.vult.pignus.config.handler;

import com.alibaba.fastjson.JSON;
import com.vult.pignus.common.entity.JsonResult;
import com.vult.pignus.common.enums.ResultCode;
import com.vult.pignus.common.utils.ResultTool;
import com.vult.pignus.entity.SysUser;
import com.vult.pignus.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Component
public class CustomizeAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private SysUserService sysUserService;


    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        Authentication authentication)
            throws IOException, ServletException {
        User userDetails = (User) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        SysUser sysUser = sysUserService.queryByAccount(userDetails.getUsername());
        Date date = new Date();
        sysUser.setLastLoginTime(date);
        sysUser.setUpdateTime(date);
        sysUser.setUpdateUser(sysUser.getId());
        sysUserService.update(sysUser);

        JsonResult result = ResultTool.success();
        httpServletResponse.setContentType("text/json;charset=utf-8");
        httpServletResponse.getWriter().write(JSON.toJSONString(result));
    }
}

package com.vult.pignus.service;

import com.vult.pignus.entity.SysUser;

import java.util.List;

public interface SysUserService {
    SysUser queryById(Integer id);
    SysUser queryByAccount(String account);
    List<SysUser> queryAll();
    SysUser insert(SysUser sysUser);
    SysUser update(SysUser sysUser);
    boolean deleteById(Integer id);

}

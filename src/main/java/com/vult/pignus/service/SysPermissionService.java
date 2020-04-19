package com.vult.pignus.service;

import com.vult.pignus.entity.SysPermission;

import java.util.List;

public interface SysPermissionService {
    SysPermission queryById(Integer id);
    List<SysPermission> queryAll();
    SysPermission insert(SysPermission sysPermission);
    SysPermission update(SysPermission sysPermission);
    boolean deleteById(Integer id);
    List<SysPermission> selectListByUser(Integer userId);
    List<SysPermission> selectListByPath(String path);
}

package com.vult.pignus.service.impl;

import com.vult.pignus.entity.SysPermission;
import com.vult.pignus.repository.SysPermissionRepository;
import com.vult.pignus.service.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SysPermissionServiceImpl implements SysPermissionService {

    @Autowired
    private SysPermissionRepository sysPermissionRepository;

    @Override
    public SysPermission queryById(Integer id) {
        return sysPermissionRepository.queryById(id);
    }

    @Override
    public List<SysPermission> queryAll() {
        return sysPermissionRepository.findAll();
    }

    @Override
    public SysPermission insert(SysPermission sysPermission) {
        return sysPermissionRepository.save(sysPermission);
    }

    @Override
    public SysPermission update(SysPermission sysPermission) {
        return sysPermissionRepository.save(sysPermission);
    }

    @Override
    public boolean deleteById(Integer id) {
        if (sysPermissionRepository.queryById(id) == null)
            return false;
        sysPermissionRepository.deleteById(id);
        return true;
    }

    @Override
    public List<SysPermission> selectListByUser(Integer userId) {
        return sysPermissionRepository.selectListByUser(userId);
    }

    @Override
    public List<SysPermission> selectListByPath(String path) {
        return sysPermissionRepository.selectListByPath(path);
    }
}

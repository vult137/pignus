package com.vult.pignus.service.impl;

import com.vult.pignus.entity.SysUser;
import com.vult.pignus.repository.SysUserRepository;
import com.vult.pignus.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserRepository sysUserRepository;

    @Override
    public SysUser queryById(Integer id) {
        return sysUserRepository.getById(id);
    }

    @Override
    public SysUser queryByAccount(String account) {
        return sysUserRepository.getByAccount(account);
    }

    @Override
    public List<SysUser> queryAll() {
        return sysUserRepository.findAll();
    }

    @Override
    public SysUser insert(SysUser sysUser) {
        return sysUserRepository.save(sysUser);
    }

    @Override
    public SysUser update(SysUser sysUser) {
        return sysUserRepository.save(sysUser);
    }

    @Override
    public boolean deleteById(Integer id) {
        if (sysUserRepository.getById(id) == null)
            return false;
        sysUserRepository.deleteById(id);
        return true;
    }

    public static void main(String[] args) {
        SysUserServiceImpl sysUserService = new SysUserServiceImpl();
        System.out.println(sysUserService.queryById(1));
    }
}

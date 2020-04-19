package com.vult.pignus.repository;

import com.vult.pignus.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SysUserRepository extends JpaRepository<SysUser, Integer> {
    SysUser getById(Integer id);

    SysUser getByAccount(String account);

    void deleteById(Integer id);
}

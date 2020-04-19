package com.vult.pignus.repository;

import com.vult.pignus.entity.SysPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SysPermissionRepository extends JpaRepository<SysPermission, Integer> {
    SysPermission queryById(Integer id);

    void deleteById(Integer id);

    @Query(value =
            "SELECT p.* FROM sys_user AS u " +
            "LEFT JOIN sys_user_role_relation AS ur ON u.id = ur.user_id " +
            "LEFT JOIN sys_role AS r ON r.id = ur.role_id " +
            "LEFT JOIN sys_role_permission_relation AS rp ON r.id = rp.role_id " +
            "LEFT JOIN sys_permission AS p ON p.id = rp.permission_id " +
            "WHERE u.id = :userId",
            nativeQuery=true)
    List<SysPermission> selectListByUser(@Param("userId") Integer userId);

    @Query(value="SELECT pe.* FROM sys_permission pe " +
            "LEFT JOIN sys_request_path_permission_relation re ON re.permission_id = pe.id " +
            "LEFT JOIN sys_request_path pa ON pa.id = re.url_id " +
            "WHERE pa.url = :path",
            nativeQuery=true)
    List<SysPermission> selectListByPath(@Param("path") String path);

}

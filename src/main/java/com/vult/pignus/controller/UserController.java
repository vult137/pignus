package com.vult.pignus.controller;

import com.vult.pignus.common.entity.JsonResult;
import com.vult.pignus.common.utils.ResultTool;
import com.vult.pignus.entity.SysUser;
import com.vult.pignus.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private SysUserService sysUserService;

    @GetMapping("/getUser")
    public @ResponseBody
    JsonResult<List<SysUser>> getUser() {
        JsonResult<List<SysUser>> result;
        result = ResultTool.success(sysUserService.queryAll());
        return result;
    }
}

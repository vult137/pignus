package com.vult.pignus.controller;

import com.vult.pignus.common.entity.JsonResult;
import com.vult.pignus.common.utils.ResultTool;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @GetMapping("")
    public @ResponseBody JsonResult<String> hello() {
        return ResultTool.success("Hello Spring");
    }
}

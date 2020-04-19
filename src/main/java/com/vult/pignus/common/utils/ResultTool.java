package com.vult.pignus.common.utils;
import com.vult.pignus.common.entity.JsonResult;
import com.vult.pignus.common.enums.ResultCode;

public class ResultTool {
    public static JsonResult<Void> success() {
        return new JsonResult<>(true);
    }

    public static <T> JsonResult<T> success(T data) {
        return new JsonResult<T>(true, data);
    }

    public static JsonResult<Void> fail() {
        return new JsonResult<>(false);
    }

    public static JsonResult<Void> fail(ResultCode resultEnum) {
        return new JsonResult<>(false, resultEnum);
    }
}

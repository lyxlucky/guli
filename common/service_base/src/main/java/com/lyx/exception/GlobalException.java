package com.lyx.exception;

import com.lyx.entity.CommonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author liao 2021/10/11
 */
@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(Exception.class)
    public CommonResult exception(Exception e){
        e.printStackTrace();
        return CommonResult.error().message("全局异常");
    }

    @ExceptionHandler(RuntimeException.class)
    public CommonResult runtimeException(RuntimeException e){
        e.printStackTrace();
        return CommonResult.error().message(e.getMessage());
    }

}

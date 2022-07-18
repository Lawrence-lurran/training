package com.nmu.training.handler.exception;


import com.nmu.training.common.Result;
import com.nmu.training.common.ResultInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description:
 *
 * @author lurran
 * @data Created on 2022/4/6 8:43 下午
 */
@Slf4j
@ControllerAdvice
public class GlobalException {
    @ExceptionHandler(MyRuntimeException.class)
    @ResponseBody
    public Result myRuntimeException(MyRuntimeException e){
        log.error("自定义异常抛出:{}",e.getMessage());
        return Result.error().codeAndMessage(e.getCode(),e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result exception(Exception e){
        log.error("全局异常处理:{}",e.getMessage());
        return Result.error().codeAndMessage(ResultInfo.GlOBAL_ERROR);
    }


}

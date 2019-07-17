package com.bdqn.ssm.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlodalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody

    public Object handleException(HttpServletRequest request,Exception e)throws  Exception{

        Map<String,Object> resposeData =new HashMap<>();
        if (e instanceof  BusinessException){
//            BusinessException businessException=new BusinessException();
            BusinessException businessException= (BusinessException) e;
            resposeData.put("errCode",businessException.getErrorCode());
            resposeData.put("errMsg",businessException.getErrMsg());
        }else {
            resposeData.put("errCode",EmBusinessError.UNKNOWN_ERROR.getErrorCode());
            resposeData.put("errMsg",EmBusinessError.UNKNOWN_ERROR.getErrMsg());

        }
        return CommonReturnType.create(resposeData,"fail");
    }
}

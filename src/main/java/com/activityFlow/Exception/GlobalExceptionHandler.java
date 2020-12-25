package com.activityFlow.Exception;

import com.activityFlow.contanst.ResponseConstants;
import com.activityFlow.vo.ResponseResultVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liufenming <liu.fenming@chinaott.onaliyun.com>
 * @Date: 2020/12/25
 * @Description 全局异常处理
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseResultVo handleMethodArgumentNotValidException(
            MethodArgumentNotValidException e) {
        logger.error("MethodArgumentNotValidException: ", e);
        return handleBindingResult(e.getBindingResult());
    }

    private ResponseResultVo handleBindingResult(BindingResult result) {
        //把异常处理为对外暴露的提示
        List<String> list = new ArrayList<>();
        if (result.hasErrors()) {
            List<ObjectError> allErrors = result.getAllErrors();
            for (ObjectError objectError : allErrors) {
                String message = objectError.getDefaultMessage();
                list.add(message);
            }
        }
        return new ResponseResultVo(ResponseConstants.ERROR_CODE, ResponseConstants.ERROR_MSG, list.toString());
    }

    @ExceptionHandler(MyException.class)
    @ResponseBody
    public ResponseResultVo MyException(
            Exception e) {
        logger.error("MyException: ", e);
        String code = ErrorCode.getCodeByMessage(e.getMessage());
        return new ResponseResultVo(Integer.valueOf(code), e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseResultVo Exception(
            Exception e) {
        logger.error("Exception: ", e);
        return new ResponseResultVo(ResponseConstants.ERROR_CODE, ResponseConstants.ERROR_MSG);
    }
}
package com.yahto.hydra.exception;

import com.yahto.hydra.model.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yahto on 2019-06-06 16:27
 *
 * @author yahto
 */
@RestController
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = BaseException.class)
    public ResponseEntity<Result> baseExceptionHandler(HttpServletRequest req, Exception e) {
        log.error("---BaseException Handler---Host:{} invokes url:{} ERROR:{} cause:{}",
                req.getRemoteHost(), req.getRequestURL(), e.getMessage(), e.getCause());
        Result result = new Result().fail("internal error");
        if (e instanceof DataBaseException) {
            result.fail(((DataBaseException) e).getMsg());
        }
        return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
    }

//    @ExceptionHandler(value = Throwable.class)
//    public ResponseEntity<Result> exception(HttpServletRequest req, Exception e) {
//        log.error("---BaseException Handler---Host:{} invokes url:{} ERROR:{} cause:{}",
//                req.getRemoteHost(), req.getRequestURL(), e.getMessage(), e.getCause());
//        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//    }

}

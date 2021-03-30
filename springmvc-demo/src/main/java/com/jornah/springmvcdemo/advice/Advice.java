package com.jornah.springmvcdemo.advice;


import com.jornah.springmvcdemo.exception.BaseBusinessException;
import com.jornah.springmvcdemo.exception.NotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice(annotations = RestController.class)
public class Advice {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    @ResponseBody
    public Object handleRuntimeException(NotFoundException ex) {
        return getMsgFromConfig(ex);
    }

    private String getMsgFromConfig(BaseBusinessException ex) {
        Map<String, String> map = new HashMap<>();
        map.put("error", "RuntimeException");
        map.put("ex", ex.toString());
        return map.toString();
    }
}

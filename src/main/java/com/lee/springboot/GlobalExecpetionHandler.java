package com.lee.springboot;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExecpetionHandler {

    @ExceptionHandler
    @ResponseBody
    public Map<String, Object> handleNPE(NullPointerException e) {
        Map map = new HashMap();
        e.printStackTrace();
        map.put("errorCode", "100");
        map.put("errorDetails", "空指针异常");
        return map;
    }

    @ExceptionHandler
    @ResponseBody
    public Map<String, Object> handleArithmeticException(ArithmeticException e) {
        Map map = new HashMap();
        e.printStackTrace();
        map.put("errorCode", "101");
        map.put("errorDetails", "ArithmeticException");
        return map;
    }

    @ExceptionHandler
    @ResponseBody
    public Map<String, Object> handleIndexOutOfBoundsException(IndexOutOfBoundsException e) {
        Map map = new HashMap();
        e.printStackTrace();
        map.put("errorCode", "102");
        map.put("errorDetails", "IndexOutOfBoundsException");
        return map;
    }

    @ExceptionHandler
    @ResponseBody
    public Map<String, Object> handleIndexOutOfBoundsException(Exception e) {
        Map map = new HashMap();
        e.printStackTrace();
        map.put("errorCode", "103");
        map.put("errorDetails", "other Exceptions");
        return map;
    }
}

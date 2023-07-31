package com.cos.blog.handler;

import com.cos.blog.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;


//ControllerAdvice : 이 컨트롤러가 어떤 클래스에서 exception이 발생하든 처리 가능하다
@ControllerAdvice
@RestController
public class GlobalExceptionHandler {
//    모든 에러를 스프링이 감지해서 이 메소드로 보내줌
//    @ExceptionHandler(value = Exception.class)
//    public String handleArgumentException(Exception e){
//        return "<h1>"+e.getMessage()+"</h1>";
//    }


    @ExceptionHandler(value=Exception.class)
    public ResponseDto<String> handleArgumentException(Exception e) {
        return new ResponseDto<String>(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()); // 500
    }

}

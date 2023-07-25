package com.cos.blog.test;

import ch.qos.logback.classic.pattern.MessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//사용자가 요청 => 응답(Html파일)
//@Controller


//사용자가 요청 => 응답(Data)
@RestController
public class HttpControllerTest {

    private static final String TAG ="HttpControllerTest: ";

//    인터넷 브라우저 요청은 무조건 get 요청 밖에 할 수 없다.
    @GetMapping("/http/get")
    public String getTest(Member m){
//        MessageConverter(스프링 부트) : 쿼리스트링 매핑
        System.out.println(TAG+"getter: "+m.getId());
        m.setId(5000);
        System.out.println(TAG+"setter: "+m.getId());

        return "get요청: "+ m.getId()+","+m.getUsername()+","+m.getPassword()+","+m.getEmail();
    }
    @PostMapping("/http/post")
    public String postTest(@RequestBody Member m){
//        MessageConverter(스프링 부트) : json 파싱해서 오브젝트(Member)에 알아서 넣어줌

        return "post요청: "+ m.getId()+","+m.getUsername()+","+m.getPassword()+","+m.getEmail();
    }

//    @PostMapping("/http/post")
//    public String postTest(@RequestBody String text){
//
//        return text;
//    }
    @PutMapping("/http/put")
    public String putTest(){
        return "putTest";
    }

    @DeleteMapping("/http/delete")
            public String deleteTest(){
        return "deleteTest";
    }

}

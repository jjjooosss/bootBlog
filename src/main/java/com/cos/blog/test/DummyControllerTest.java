package com.cos.blog.test;

import ch.qos.logback.classic.pattern.MessageConverter;
import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Supplier;

//RestController : html 파일이 아니라 data를 리턴해주는 controller
@RestController
public class DummyControllerTest {

    @Autowired//의존성주입(DI)
    private UserRepository userRepository;

    @GetMapping("/dummy/user")
    public List<User> list(){
        return userRepository.findAll();
    }

    @GetMapping("/dummy/user/page/{page}")
//    스프링 부트의 자동 페이징기능
//    2건씩 들고오고, id기준 최신순 정렬
    public Page<User> pageList(@PageableDefault(size = 2, sort = "id",direction = Sort.Direction.DESC)Pageable pageable){
        Page<User> users = userRepository.findAll(pageable);
        return users;
    }
//    {id} 주소로 파라미터를 전달 받을 수 있음.
//    http://localhost:8000/blog/dummy/user/3
    @GetMapping("/dummy/user/{id}")
    public User detail(@PathVariable int id){
//        user/4를 찾을때 내가 db에서 못찾으면 user = null이됨
//        그럼 return null, ==> 문제생김
//        Optional로 너의 User 객체를 감싸서 가져올테니 null인지 아닌지 판단하여 return해!
//            supplier는 인터페이스라서 new불가, 하려면 익명클래스로 만들어야되서 이거 오버라이딩하는거
        User user= userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
//            supplier는 인터페이스라서 new불가, 하려면 익명클래스로 만들어야되서 이거 오버라이딩하는거
            @Override
            public IllegalArgumentException get() {
                return new IllegalArgumentException("해당 유저는 없습니다. id :"+id);
            }
        });
//       리턴타입 user(자바 오브젝트), restController니까 data 리턴하는디, 웹브라우저가 user 당연히 이해 못함!
//        변환(웹브라우저가 이해할 수 있는 데이터)-> json(스프링에서 Gson 라이브러리 사용해서 변환했었음)
//        그러나 스프링부트에서는 MessageConverter가 응답시에 자동 작동! 알아서 json을 리턴해줌
//        만약에 자바 오브젝트를 리턴하게 되면 MessageConverter가 jackson 라이브러리르 호출해서 user오브젝트를 json으로 변환해서 브라우저에 던져줌
        return user;



    }

//    http://localhost:8000/blog/dummy/join(요청)
//    http의 body에 username, password, email 데이터를 가지고 (요청)
    @PostMapping("/dummy/join")
//    public String join(String username, String password, String email){//key=value(스프링 약속된 규칙)
    public String join(User user){//key=value(스프링 약속된 규칙)
//        System.out.println("username = " + username + ", password = " + password + ", email = " + email);
        System.out.println("id = " + user.getId());
        System.out.println("username = " + user.getUsername());
        System.out.println("password = " + user.getPassword());
        System.out.println("email = " + user.getEmail());
        System.out.println("role = " + user.getRole());
        System.out.println("createDate = " + user.getCreateDate());

//        user.setRole("user"); : 이렇게 직접 입력시 실수 할 수 있음, enum쓰기
        user.setRole(RoleType.USER);
        userRepository.save(user);
        return "회원가입이 완료되었습니다.";
    }
}

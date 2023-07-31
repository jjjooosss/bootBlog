package com.cos.blog.service;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

//스프링이 컴포넌트 스캔을 통해서 Bean에 등록을 해줌. == Ioc를 해준다
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public int 회원가입(User user){

        user.setRole(RoleType.USER);
        try {
            userRepository.save(user);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("UserService: 회원가입() :"+e.getMessage());
        }
        return -1;
    }
}

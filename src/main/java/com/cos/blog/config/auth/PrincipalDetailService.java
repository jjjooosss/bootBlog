package com.cos.blog.config.auth;

import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service //Bean등록
public class PrincipalDetailService implements UserDetailsService {

    @Autowired
   private UserRepository userRepository;

//    스프링이 로그인 요청을 가로챌 때, username, password 변수 2개를 가로채는데
//    password부분 처리는 알아서 함
//    username이 db에 있는지만 확인해 주면 됨.
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        이걸 오버라이딩해서 구현하지 않으면 우리가 만든 user값이 아니라 스프링 시큐리티 기본 user값 들어감
        User principal = userRepository.findByUsername(username)
                .orElseThrow(()->{
                    return new UsernameNotFoundException("해당 사용자를 찾을 수 없습니다. :"+username);
                });
        return new PrincipalDetail(principal); // 시큐리티의 세션에 유저 정보가 저장이 됨.
    }
}

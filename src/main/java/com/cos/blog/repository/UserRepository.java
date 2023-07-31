package com.cos.blog.repository;

import com.cos.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

//DAO역할
//자동으로 BEAN 등록 되서 @Repository 생략가능
public interface UserRepository extends JpaRepository<User, Integer> {

}



//    JPA naming 쿼리 findBy1번컬럼And2번컬럼(첫글자 대문자로 적으면 됨)
//    SELECT * FROM user WHERE username =?1 AND password =?2;
//    User findByUsernameAndPassword(String username, String password);

//    네이티브 쿼리
//    @Query(value = "SELECT * FROM user WHERE username =?1 AND password =?2", nativeQuery = true)
//    User login(String username, String password);
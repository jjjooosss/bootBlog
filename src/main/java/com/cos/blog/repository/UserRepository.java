package com.cos.blog.repository;

import com.cos.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//DAO역할
//자동으로 BEAN 등록 되서 @Repository 생략가능
public interface UserRepository extends JpaRepository<User, Integer> {

}

package com.cos.blog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity//user 클래스가 MySQL에 테이블 생성이 된다
//@DynamicInsert
public class User {

    @Id //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 프로젝트에서 연결된 db의 넘버링 전략을 따라간다.
    private int id; // 시퀀스,auto_increment

    @Column(nullable = false, length = 30)
    private String username;//아이디

//    패스워드를 해쉬로 변경해서 암호화할거라서, 넉넉하게 100으로 준다
    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = false, length = 50)
    private String email;


//    @ColumnDefault("'user'")//"''"=> 안에 있는게 문자열임을 알려준다.
//    private String role; //Enum을 쓰는게 좋음
//    DB는 RoleType이라는 게 없다
    @Enumerated(EnumType.STRING)
    private RoleType role; //Enum을 쓰는게 좋음// admin, user
    // => admin, user, manager 등의 역할부여시 String이라면 managerrr 등의 오타 낼 수 있음
    // 그러나 enum을 쓸 경우 domain(범위)을 쓸 수 있기 때문에 오타낼 걱정 x

    @CreationTimestamp //시간이 자동 입력됨 (mysql: now나 oracle: sysdate를 안써도됨)
    private Timestamp createDate;

}

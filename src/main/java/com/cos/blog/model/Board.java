package com.cos.blog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Board {

    @Id //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 100)
    private String title;

    @Lob //대용량 데이터
    private String content; //섬머노트 라이브러리 사용하면 <html> 태그가 섞여서 디자인이 됨. => 데이터 크기 매우 큼

    private int count;//조회수


    @ManyToOne(fetch = FetchType.EAGER) //many =Board, user =One 한명의 유저는 여러개의 게시글 쓸 수 있음
    @JoinColumn(name = "userId")
    private User user; // 작성자
    //db는 오브젝트를 사용할 수 없어서 보통 fk를 사용, int user 이렇게 사용하겠지만
    // jpa는 오브젝트 저장 가능함.

    @OneToMany(mappedBy = "board",fetch = FetchType.EAGER) //mapppedBy : 연관관계의 주인이 아니다(난 fk가 아니에요) db에 컬럼을 만들지 마세요.
//    mappedBy 에 있는거 : 필드이름
    private List<Reply> reply;

    @CreationTimestamp
    private Timestamp createDate;


}

package com.cos.blog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Reply {
    @Id //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 200)
    private String content;

    @ManyToOne //하나의 게시글에는 여러개의 답변이 올 수 있다.
    @JoinColumn(name = "boardId")
    private Board board; //원글

    @ManyToOne //한명의 유저는 여러개의 답변을 쓸 수 있음
    @JoinColumn(name = "userId")
    private User user; // 작성자

    @CreationTimestamp
    private Timestamp createDate;
}

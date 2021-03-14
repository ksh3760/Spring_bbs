// DB모델 클래스 : JPA를 통해 DB를 사용할 수 있다.
package com.bbs.myBbs.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data    // lombok Data anotation을 통해 변수들을 getter, setter을 하지 않고도 사용가능
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min=2, max=30, message = "제목은 2자이상 30자 이하입니다.")   // xss 방어
    private String title;
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;
}

package com.example.ddooheeJpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member") // 멤버의 측에선 하나의 회원이 여러개의 주문을 하기 때문에 -> 일대다 관계계
    private List<Order> orders = new ArrayList<>();
    // 컬렉션을 생성 후 바꾸지 말기
}

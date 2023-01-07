package com.example.ddooheeJpa.repository;

import com.example.ddooheeJpa.domain.OrderStatus;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OderSearch {

    private String memberName; // 회원 이름
    private OrderStatus orderStatus; //주문 상태[ORDER, CANCLE]
}

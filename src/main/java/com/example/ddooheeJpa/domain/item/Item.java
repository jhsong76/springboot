package com.example.ddooheeJpa.domain.item;

import com.example.ddooheeJpa.domain.Category;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // 한 테이블에 다 때려박는것.
@DiscriminatorColumn(name = "dtype")
@Getter @Setter
public abstract class Item {

    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "items") // 중간 테이블 mapping 필요
    private List<Category> categories = new ArrayList<>();

}

package com.example.ddooheeJpa.controller;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BookForm {

    private Long id;
    private String name;햐
    private int price;
    private int stockQuantity;
    private String author;
    private String isbn;

}

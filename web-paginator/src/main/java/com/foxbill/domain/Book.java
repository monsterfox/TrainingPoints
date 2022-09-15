package com.foxbill.domain;

import lombok.Data;

/**
 * Book实体类
 */
@Data
public class Book {
    private int id;
    private String name;
    private float price;
    private int pnum;
    private String category;

}

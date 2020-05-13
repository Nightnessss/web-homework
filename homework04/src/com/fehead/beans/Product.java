package com.fehead.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Nightessss 2020/5/12 16:12
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private Integer id;
    private String name;
    private String brand;
    private Double price;
    private Integer stock;
}

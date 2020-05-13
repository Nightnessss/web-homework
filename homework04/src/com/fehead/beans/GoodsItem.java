package com.fehead.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Nightessss 2020/5/12 16:13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsItem {

    private Integer id;
    private String name;
    private Double price;

}

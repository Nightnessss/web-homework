package com.fehead.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Nightessss 2020/5/12 16:13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCart {

    private Integer id;
    private List<GoodsItem> goodsItems;
}

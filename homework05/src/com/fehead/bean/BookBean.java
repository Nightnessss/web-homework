package com.fehead.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Nightessss 2020/5/14 16:29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookBean {
    private String bookId;
    private String title;
    private String author;
    private String publisher;
    private Float price;
}

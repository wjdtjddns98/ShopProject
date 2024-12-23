package org.example.shop.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemDto {

    private Long id;

    private String itemNm;

    private int price;
    private int stockNumber;

    private String itemDetail;


    private String itemsellStatus;

    private LocalDateTime regTime;

    private LocalDateTime updateTime;

}
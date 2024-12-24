package org.example.shop.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.shop.constant.ItemSellStatus;

@Getter
@Setter
@ToString
public class ItemSearchDto {

    private String searchDateType;

    private ItemSellStatus searchSellStatus;

    private String searchBy;

    private String searchQuery = "";

}

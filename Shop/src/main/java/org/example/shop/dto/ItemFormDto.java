package org.example.shop.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.example.shop.constant.ItemSellStatus;
import org.example.shop.entity.Item;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemFormDto {

    private Long id;

    @NotBlank(message ="상품명은 필수 입력 항목 입니다")
    private String itemNm;

    @NotNull(message = "가격은 필수 입력 항목 입니다")
    private int price;

    @NotNull(message ="수량은 필수 입력 항목 입니다")
    private int stockNumber;

    @NotBlank
    private String itemDetail;

    private ItemSellStatus itemSellStatus;

    private List<ItemImgDto> itemImgDtoList = new ArrayList<>();

    private List<Long> itemImgIds = new ArrayList<>();

    private static ModelMapper modelMapper = new ModelMapper();

    public Item createItem(){
        return modelMapper.map(this, Item.class);
    }

    public static ItemFormDto entityToDto(Item item){
        return modelMapper.map(item, ItemFormDto.class);
    }



}

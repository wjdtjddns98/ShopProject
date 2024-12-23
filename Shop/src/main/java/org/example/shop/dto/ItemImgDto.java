package org.example.shop.dto;

import lombok.*;
import org.example.shop.entity.ItemImg;
import org.modelmapper.ModelMapper;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemImgDto {
    private Long id;
    private String imgName;
    private String oriImgName;
    private String imgUrl;
    private String regImgYn;

   private static ModelMapper modelMapper = new ModelMapper();

   public static ItemImgDto entityToDto(ItemImg itemImg) {
      return modelMapper.map(itemImg, ItemImgDto.class);
   }

}
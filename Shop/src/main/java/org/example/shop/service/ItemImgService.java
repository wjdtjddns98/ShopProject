package org.example.shop.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.shop.entity.ItemImg;
import org.example.shop.repository.ItemImgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.StringUtils;

import java.io.IOException;

@Service
@RequiredArgsConstructor
@Transactional
public class ItemImgService {

    @Value("${itemImgLocation}")
    private String itemImgLocation;

    private final ItemImgRepository itemImgRepository;
    private final FileService fileService;

    public void updateItemImg(Long itemImgId, MultipartFile itemImgFile) throws IOException {
        if(!itemImgFile.isEmpty()) {
            ItemImg itemImg = itemImgRepository.findById(itemImgId).orElseThrow(EntityNotFoundException::new);

            if(!StringUtils.isEmpty(itemImg.getImgName())){
               fileService.deleteFile(itemImgLocation + "/" + itemImg.getImgName());
            }
            String oriImgName = itemImgFile.getOriginalFilename();
            String imgName = "";
            String imgUrl = "";

            if(!StringUtils.isEmpty(oriImgName)) {
                imgName = fileService.uploadFile(itemImgLocation, oriImgName, itemImgFile.getBytes());
                imgUrl = "/images/item/" + imgName;
            }

            itemImg.updateItemImg(oriImgName, imgName, imgUrl);
        }
    }

    public void saveItemImg(ItemImg itemImg, MultipartFile itemImgFile) throws IOException {
        String oriImgName = itemImgFile.getOriginalFilename();
        String imgName = "";
        String imgUrl = "";

        if(!StringUtils.isEmpty(oriImgName)) {
            imgName = fileService.uploadFile(itemImgLocation, oriImgName, itemImgFile.getBytes());
            imgUrl = "/images/item/" + imgName;
        }

        itemImg.updateItemImg(oriImgName, imgName, imgUrl);
        itemImgRepository.save(itemImg);
    }


}

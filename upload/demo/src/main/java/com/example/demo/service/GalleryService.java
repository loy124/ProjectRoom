package com.example.demo.service;

/**
 * GalleryService
 */

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.domain.GalleryRepository;
import com.example.demo.domain.entity.GalleryEntity;
import com.example.demo.dto.GalleryDto;

import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GalleryService {
  private GalleryRepository galleryRepository;

  public void savePost(GalleryDto galleryDto) {
    galleryRepository.save(galleryDto.toEntity());
  }

  public List<GalleryDto> getList() {
    List<GalleryEntity> galleryEntityList = galleryRepository.findAll();
    List<GalleryDto> galleryDtoList = new ArrayList<>();

    for (GalleryEntity galleryEntity : galleryEntityList) {
      galleryDtoList.add(convertEntityToDto(galleryEntity));
    }

    return galleryDtoList;
  }

  private GalleryDto convertEntityToDto(GalleryEntity galleryEntity) {
    return GalleryDto.builder().id(galleryEntity.getId()).title(galleryEntity.getTitle())
        .filePath(galleryEntity.getFilePath())
        .imgFullPath("https://" + S3Service.CLOUD_FRONT_DOMAIN_NAME + "/" + galleryEntity.getFilePath()).build();
  }

}
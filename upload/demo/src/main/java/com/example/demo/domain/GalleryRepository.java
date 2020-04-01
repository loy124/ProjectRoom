package com.example.demo.domain;

import java.util.List;

import com.example.demo.domain.entity.GalleryEntity;

/**
 * GalleryRepository
 */

import org.springframework.data.jpa.repository.JpaRepository;

public interface GalleryRepository extends JpaRepository<GalleryEntity, Long> {
  @Override
  List<GalleryEntity> findAll();
}
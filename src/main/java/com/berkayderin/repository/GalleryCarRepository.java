package com.berkayderin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.berkayderin.model.GalleryCar;

@Repository
public interface GalleryCarRepository extends JpaRepository<GalleryCar, Long> {

}

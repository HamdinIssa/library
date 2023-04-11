package com.example.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.multipart.MultipartFile;

import com.example.library.entity.Images;


public interface UploadRepository extends JpaRepository<Images, Integer> {

    Images save(MultipartFile img);

}

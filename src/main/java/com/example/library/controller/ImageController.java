package com.example.library.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.library.entity.Images;
import com.example.library.repository.UploadRepository;

import jakarta.servlet.http.HttpSession;
import lombok.experimental.FieldDefaults;



// @Controller
// @RequestMapping("/image")
// @FieldDefaults(level = AccessLevel.PRIVATE)
// public class ImageController {
    
// }

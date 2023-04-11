package com.example.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library.entity.Blog;

public interface BlogRepository extends JpaRepository<Blog,Integer> {

}

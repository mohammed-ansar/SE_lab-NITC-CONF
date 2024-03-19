 package com.seproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seproject.entity.Paper;

public interface PaperRepo extends JpaRepository<Paper, Integer> {

}

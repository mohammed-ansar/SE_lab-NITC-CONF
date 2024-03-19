package com.seproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seproject.entity.Papers;
import com.seproject.entity.Reviewers;

public interface ReviewersRepo extends JpaRepository<Reviewers, Long> {

}

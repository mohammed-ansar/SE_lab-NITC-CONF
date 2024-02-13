 package com.seproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seproject.entity.Papers;

public interface PapersRepo extends JpaRepository<Papers, Integer> {

}

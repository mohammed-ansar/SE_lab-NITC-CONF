package com.seproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seproject.entity.Papers;
import com.seproject.entity.Reviewers;
import com.seproject.repository.ReviewersRepo;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@Service
public class ReviewersService {

	@Autowired
	private ReviewersRepo reviewersRepo;
	
    public List<Reviewers> getAllReviewers() {
        return reviewersRepo.findAll();
    }

}

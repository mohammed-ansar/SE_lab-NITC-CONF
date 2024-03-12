package com.seproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seproject.entity.Papers;
import com.seproject.entity.User;
import com.seproject.repository.PapersRepo;
import com.seproject.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
//@Transactional
public class PapersService {

	@Autowired
	private PapersRepo paperRepo;
	
	public Papers saveDetails(Papers paper) {
		return  paperRepo.save(paper);
	}
	
	public Papers getPapersDetailsById(int id) {
		return paperRepo.findById(id).orElse(null);
	}
	
	public Papers updatePapers(Papers paper) {
		return paperRepo.save(paper);
	}
	
    public List<Papers> getAllPapers() {
        return paperRepo.findAll();
    }


	
}

package com.seproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seproject.entity.Paper;
import com.seproject.entity.Papers;
import com.seproject.entity.User;
import com.seproject.repository.PaperRepo;
import com.seproject.repository.PapersRepo;
import com.seproject.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
//@Transactional
public class PaperService {

	@Autowired
	private PaperRepo paperRepo;
	
	public Paper saveDetails(Paper paper) {
		return  paperRepo.save(paper);
	}
	
	public Paper getPaperDetailsById(int id) {
		Paper paper = paperRepo.findById(id).orElse(null);
		System.out.println("Getting Paper By Id: " + paper);
		return paper;
	}	
	
	
    public List<Paper> getAllPapers() {
    	List<Paper> papers = paperRepo.findAll();
    	System.out.println("Getting data from DB: " + papers);
        return papers;
    }
    
	public Paper updatePaper(Paper paper) {
		return paperRepo.save(paper);
	}

	
}

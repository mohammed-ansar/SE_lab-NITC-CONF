package com.seproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "paper_submissions4")
@NoArgsConstructor
public class Paper {
	
	@Id
	@Column(name="serial_no:")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String submission;
	
	private String Department;
	
	private String state;
	
	private String reviewer;
	
	private String review_state;
	
	private String review;
	
	private String decision_state;
	
	private String Decision;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubmission() {
		return submission;
	}

	public void setSubmission(String submission) {
		this.submission = submission;
	}

	public String getDepartment() {
		return Department;
	}

	public void setDepartment(String department) {
		Department = department;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getReviewer() {
		return reviewer;
	}

	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
	}
	
	public String getReview_state() {
		return review_state;
	}

	public void setReview_state(String review_state) {
		this.review_state = review_state;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getDecision_state() {
		return decision_state;
	}

	public void setDecision_state(String decision_state) {
		this.decision_state = decision_state;
	}

	public String getDecision() {
		return Decision;
	}

	public void setDecision(String decision) {
		Decision = decision;
	}
	
	public Paper() {
		
	}
	
   public Paper(int id, String submission, String Department, String state, String reviewer, String review_state, String review, String decision_state, String Decision) {
        this.id = id;
        this.submission = submission;
        this.Department = Department;
        this.state = state;
        this.reviewer = reviewer;
        this.review_state = review_state;
        this.review = review;
        this.decision_state = decision_state;
        this.Decision = Decision;
    } 

}

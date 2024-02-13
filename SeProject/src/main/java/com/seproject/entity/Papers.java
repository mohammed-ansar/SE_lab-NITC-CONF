package com.seproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "paper_submissions2")
@NoArgsConstructor
public class Papers {
	
	@Id
	@Column(name="serial_no:")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="submission")
	private String submission;
	
	@Column(name="reviewer")
	private String reviewer;
	
	@Column(name="decision")
	private String decision;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubmissions() {
		return submission;
	}

	public void setSubmissions(String submissions) {
		this.submission = submissions;
	}

	public String getReview() {
		return reviewer;
	}

	public void setReview(String review) {
		this.reviewer = review;
	}

	public String getDecision() {
		return decision;
	}

	public void setDecision(String decision) {
		this.decision = decision;
	}
	
	
}

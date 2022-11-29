package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "questions")
public class Question {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false,length=300)
	private String statement;

	
	/*
	 * foreign key
	 * many question will be connected to one exam
	 * 
	 */
	@ManyToOne
	@JoinColumn(name= "exam_id", nullable=false)
	private Exam exams;


	@OneToMany(mappedBy="questions")
	private List<Option> options= new ArrayList<Option>();

	@OneToOne(mappedBy="questions")
	private Answer answer;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatement() {
		return statement;
	}

	public void setStatement(String statement) {
		this.statement = statement;
	}

	public Exam getExams() {
		return exams;
	}

	public void setExams(Exam exams) {
		this.exams = exams;
	}


	public List<Option> getOptions() {
		return options;
	}



	public Answer getAnswer() {
		return answer;
	}
}

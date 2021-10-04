package com.map;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Question {

	@Id
	@Column(name = "question_id")
	private int questionId;

	private String question;

	// one Question can have many answers drop 3rd table created in last branch else errors
	//join column ka kaam mappedBy laga ke Question table se cheen liya gaya h aur Answer table 
	//k question object ko de diya gya h join column will only be created in Answer table
	
	@OneToMany(mappedBy="question",fetch = FetchType.EAGER)
	private List<Answer> answers;

	public Question(int questionId, String question, List<Answer> answers) {
		super();
		this.questionId = questionId;
		this.question = question;
		this.answers = answers;
	}

	public Question() {
		super();
		
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

}

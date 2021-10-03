package com.map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Question {
   
	
	
	@Id
    @Column(name="question_id")
	private int questionId;
	
	
	
	private String question;
	
	
	//my not : for each question there is an answer but vice versa is not true in embaddable  vice versa is aso true
	//@oneToOne will put PK of Answer table as FK inside Question table so this is a FK
	//@JoinColumn for renaming the FK constraint that will be stored in Question table isse pehle y hibernate ise 
	//answer_answer_id nam se save karta
	
	@OneToOne
	@JoinColumn(name="a_id")
	private Answer answer;

	public Question(int questionId, String question, Answer answer) {
		super();
		this.questionId = questionId;
		this.question = question;
		this.answer = answer;
	}

	public Question() {
		super();
		// TODO Auto-generated constructor stub
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

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}
	
	
	
	
	
}

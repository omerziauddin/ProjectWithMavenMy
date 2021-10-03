package com.map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Answer {

	@Id
	@Column(name = "answer_id")
	private int answerId;

	private String answer;

	// for every answer we will take out from db we will also get the question of
	// that answer
	// saari mapping ka dhyan answer rakhega
	// The field that owns the relationship. Thiselement
	// is only specified on the inverse (non-owning)side of the association.

	@OneToOne(mappedBy = "answer")
	private Question question;

	public int getAnswerId() {
		return answerId;
	}

	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Answer(int answerId, String answer, Question question) {
		super();
		this.answerId = answerId;
		this.answer = answer;
		this.question = question;
	}

	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Answer [answerId=" + answerId + ", answer=" + answer + ", question=" + question + "]";
	}

}

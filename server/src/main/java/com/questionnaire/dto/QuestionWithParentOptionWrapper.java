package com.questionnaire.dto;

public class QuestionWithParentOptionWrapper {

	private Integer questionId;
	
	private Integer parentOptionId;
	

	public QuestionWithParentOptionWrapper(Integer questionId, Integer parentOptionId) {
		super();
		this.questionId = questionId;
		this.parentOptionId = parentOptionId;
	}

	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public Integer getParentOptionId() {
		return parentOptionId;
	}

	public void setParentOptionId(Integer parentOptionId) {
		this.parentOptionId = parentOptionId;
	}

	@Override
	public String toString() {
		return "QuestionWrapper [questionId=" + questionId + ", parentOptionId=" + parentOptionId + "]";
	}
	
}

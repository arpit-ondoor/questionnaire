package com.questionnaire.dto;

import java.util.List;

public class QuestionnaireDto {

	private List<QuestionsDto> questions;

	public List<QuestionsDto> getQuestions() {
		return questions;
	}

	public void setQuestions(List<QuestionsDto> questions) {
		this.questions = questions;
	}

	@Override
	public String toString() {
		return "QuestionnaireDto [questions=" + questions + "]";
	}

}

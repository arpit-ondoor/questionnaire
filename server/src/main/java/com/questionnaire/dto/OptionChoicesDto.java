package com.questionnaire.dto;

import java.util.List;

public class OptionChoicesDto {

	// option_choices
		// id int(11) NOT NULL AUTO_INCREMENT,
		private Integer id;

		// option_choice_name varchar(45) NOT NULL,
		private String name;

		// question_id int(11) NOT NULL,
		private Integer questionId;
		
		
		private List<QuestionsDto> questions;
		

		public List<QuestionsDto> getQuestions() {
			return questions;
		}

		public void setQuestions(List<QuestionsDto> questions) {
			this.questions = questions;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

	
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Integer getQuestionId() {
			return questionId;
		}

		public void setQuestionId(Integer questionId) {
			this.questionId = questionId;
		}

		@Override
		public String toString() {
			return "OptionChoicesDto [id=" + id + ", name=" + name + ", questionId="
					+ questionId + "]";
		}
		
		
}

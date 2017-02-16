package com.questionnaire.model;

public class OptionChoices {

	// option_choices
	// id int(11) NOT NULL AUTO_INCREMENT,
	private Integer id;

	// option_choice_name varchar(45) NOT NULL,
	private String optionChoiceName;

	// question_id int(11) NOT NULL,
	private Integer questionId;

	private transient Questions question;

	public Questions getQuestions() {
		return question;
	}

	public void setQuestions(Questions question) {
		this.question = question;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOptionChoiceName() {
		return optionChoiceName;
	}

	public void setOptionChoiceName(String optionChoiceName) {
		this.optionChoiceName = optionChoiceName;
	}

	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	@Override
	public String toString() {
		return "OptionChoices [id=" + id + ", optionChoiceName=" + optionChoiceName + ", questionId=" + questionId
				+ "]";
	}

}

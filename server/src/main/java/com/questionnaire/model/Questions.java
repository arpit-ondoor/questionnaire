package com.questionnaire.model;

public class Questions {

	private Integer id;

//question_name
	private String name;
	
//dependent_question_option_id
	private Integer dependentQuestionOptionId;

//input_type_id	
	private Integer inputTypeId;
	
	private Boolean isChild;
	
	private OptionChoices parentOption;
	
	public OptionChoices getParentOption() {
		return parentOption;
	}

	public void setParentOption(OptionChoices parentOption) {
		this.parentOption = parentOption;
	}

	public Boolean getIsChild() {
		return isChild;
	}

	public void setIsChild(Boolean isChild) {
		this.isChild = isChild;
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

	public Integer getDependentQuestionOptionId() {
		return dependentQuestionOptionId;
	}

	public void setDependentQuestionOptionId(Integer dependentQuestionOptionId) {
		this.dependentQuestionOptionId = dependentQuestionOptionId;
	}

	public Integer getInputTypeId() {
		return inputTypeId;
	}

	public void setInputTypeId(Integer inputTypeId) {
		this.inputTypeId = inputTypeId;
	}

	@Override
	public String toString() {
		return "Questions [id=" + id + ", name=" + name + ", dependentQuestionOptionId=" + dependentQuestionOptionId
				+ ", inputTypeId=" + inputTypeId + ", isChild=" + isChild + ", parentOption=" + parentOption + "]";
	}

}

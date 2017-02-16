package com.questionnaire.dto;

import java.util.List;

public class QuestionsDto {

	private Integer id;

	// question_name
	private String name;

	// dependent_question_option_id
	private Integer dependentQuestionOptionId;

	// input_type_id
	private Integer typeId;
	
	private Boolean isChild;
	

	private List<OptionChoicesDto> options;

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

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public List<OptionChoicesDto> getOptions() {
		return options;
	}

	public void setOptions(List<OptionChoicesDto> options) {
		this.options = options;
	}

	@Override
	public String toString() {
		return "QuestionsDto [id=" + id + ", name=" + name + ", dependentQuestionOptionId=" + dependentQuestionOptionId
				+ ", typeId=" + typeId + ", isChild=" + isChild + ", options=" + options + "]";
	}
	
}

package com.questionnaire.model;

public class InputTypes {

	private Integer id;

	private String inputTypeName;

	private String displayValue;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getInputTypeName() {
		return inputTypeName;
	}

	public void setInputTypeName(String inputTypeName) {
		this.inputTypeName = inputTypeName;
	}

	public String getDisplayValue() {
		return displayValue;
	}

	public void setDisplayValue(String displayValue) {
		this.displayValue = displayValue;
	}

	@Override
	public String toString() {
		return "InputTypes [id=" + id + ", inputTypeName=" + inputTypeName + ", displayValue=" + displayValue + "]";
	}

}

package com.questionnaire.jdbcdao;

import java.util.List;

import com.questionnaire.commons.exceptions.application.BusinessException;
import com.questionnaire.model.OptionChoices;

public interface OptionChoicesDao {
	
	OptionChoices add(OptionChoices optionChoice) throws BusinessException;

	List<OptionChoices> addAll(List<OptionChoices> entities) throws BusinessException;

}

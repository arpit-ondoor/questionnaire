package com.questionnaire.jdbcdao;

import java.util.List;

import com.questionnaire.commons.exceptions.application.BusinessException;
import com.questionnaire.model.InputTypes;

public interface InputTypesDao {

	List<InputTypes> getAll() throws BusinessException;

}

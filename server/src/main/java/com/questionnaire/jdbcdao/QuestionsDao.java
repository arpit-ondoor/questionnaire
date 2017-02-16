package com.questionnaire.jdbcdao;

import java.util.List;

import com.questionnaire.commons.exceptions.application.BusinessException;
import com.questionnaire.dto.QuestionWithParentOptionWrapper;
import com.questionnaire.model.Questions;

public interface QuestionsDao {

	Questions add(Questions question) throws BusinessException;

	List<Questions> addAll(List<Questions> entities) throws BusinessException;

	void setParentOption(List<QuestionWithParentOptionWrapper> wrapper);
}

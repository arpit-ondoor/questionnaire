package com.questionnaire.service;

import com.questionnaire.commons.exceptions.application.BusinessException;
import com.questionnaire.dto.QuestionnaireDto;
import com.questionnaire.dto.JsonResponseDto;

public interface QuestionsService {

	JsonResponseDto createAll(QuestionnaireDto questionnaire) throws BusinessException;

}

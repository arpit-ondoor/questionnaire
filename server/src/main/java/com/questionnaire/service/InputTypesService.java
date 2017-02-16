package com.questionnaire.service;

import com.questionnaire.commons.exceptions.application.BusinessException;
import com.questionnaire.dto.JsonResponseDto;

public interface InputTypesService {

	JsonResponseDto getAll() throws BusinessException;
}

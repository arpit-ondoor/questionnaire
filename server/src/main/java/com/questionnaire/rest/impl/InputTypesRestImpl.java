package com.questionnaire.rest.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.questionnaire.commons.exceptions.application.BusinessException;
import com.questionnaire.dto.JsonResponseDto;
import com.questionnaire.rest.InputTypesRest;
import com.questionnaire.service.InputTypesService;

@RestController
public class InputTypesRestImpl implements InputTypesRest {
	private Logger logger = LoggerFactory.getLogger(InputTypesRestImpl.class);

	@Autowired
	private InputTypesService service;

	@Override
	public JsonResponseDto getAll() throws BusinessException {
		return service.getAll();
	}

}

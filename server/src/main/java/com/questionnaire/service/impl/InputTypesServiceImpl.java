package com.questionnaire.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.questionnaire.commons.exceptions.application.BusinessException;
import com.questionnaire.dto.JsonResponseDto;
import com.questionnaire.jdbcdao.InputTypesDao;
import com.questionnaire.service.InputTypesService;

@Transactional
@Service
public class InputTypesServiceImpl implements InputTypesService {

	private Logger logger = LoggerFactory.getLogger(InputTypesServiceImpl.class);

	@Autowired
	private InputTypesDao dao;

	@Override
	public JsonResponseDto getAll() throws BusinessException {
		logger.info("Inside method getAll");
		return new JsonResponseDto(JsonResponseDto.Status.SUCCESS.getStatus(),null,dao.getAll());
	}
}

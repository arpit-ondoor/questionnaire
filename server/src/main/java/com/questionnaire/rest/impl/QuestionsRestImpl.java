package com.questionnaire.rest.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.questionnaire.commons.exceptions.application.BusinessException;
import com.questionnaire.dto.QuestionnaireDto;
import com.questionnaire.dto.JsonResponseDto;
import com.questionnaire.rest.QuestionsRest;
import com.questionnaire.service.QuestionsService;


@RestController
public class QuestionsRestImpl  implements QuestionsRest{
	private Logger logger = LoggerFactory.getLogger(QuestionsRestImpl.class);

	@Autowired
	private QuestionsService service;


@Override
public JsonResponseDto create(@RequestBody QuestionnaireDto questionnaire) throws BusinessException {
	logger.info("Inside Create Question");
	return service.createAll(questionnaire);
}

}

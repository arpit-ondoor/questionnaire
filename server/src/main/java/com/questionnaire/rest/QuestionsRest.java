package com.questionnaire.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.questionnaire.commons.exceptions.application.BusinessException;
import com.questionnaire.dto.QuestionnaireDto;
import com.questionnaire.dto.JsonResponseDto;

/**
 *
 * @author Arpit
 *
 *
 */

@RequestMapping(value="questions",produces={MediaType.APPLICATION_JSON_VALUE})
public interface QuestionsRest {

	@RequestMapping(value="create",method=RequestMethod.POST)
	public JsonResponseDto create(@RequestBody QuestionnaireDto questionnaire)throws BusinessException;
	

}

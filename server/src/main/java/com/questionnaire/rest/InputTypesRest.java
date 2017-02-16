package com.questionnaire.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.questionnaire.commons.exceptions.application.BusinessException;
import com.questionnaire.dto.JsonResponseDto;

/**
 *
 * @author Arpit
 *
 *
 */

@RequestMapping(value="inputtypes",produces={MediaType.APPLICATION_JSON_VALUE})
public interface InputTypesRest {

	@RequestMapping(value = "getall", method = RequestMethod.GET)
	public JsonResponseDto getAll() throws BusinessException ;


}

package com.questionnaire.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.questionnaire.commons.exceptions.application.BusinessException;
import com.questionnaire.jdbcdao.InputTypesDao;
import com.questionnaire.model.InputTypes;



@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext
public class TestInputTypes extends AbstractTestNGSpringContextTests {

	@Autowired
	private InputTypesDao dao;
	
	@Test
	public void findAll() throws BusinessException  {
		List<InputTypes> list =  dao.getAll();
		Assert.assertNotNull(list);
		Assert.assertTrue(!list.isEmpty());
	}
}

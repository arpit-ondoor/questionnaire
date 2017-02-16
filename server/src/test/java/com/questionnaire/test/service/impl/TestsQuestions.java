package com.questionnaire.test.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.questionnaire.commons.exceptions.application.BusinessException;
import com.questionnaire.jdbcdao.QuestionsDao;
import com.questionnaire.model.Questions;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext
public class TestsQuestions extends AbstractTestNGSpringContextTests {

	@Autowired
	private QuestionsDao dao;
	
	@Test
	public void createQuestion() throws BusinessException {
		
		Questions question = new Questions();
		question.setName("New Q");
		question.setInputTypeId(1);
		question.setDependentQuestionOptionId(null);
		Questions saveObj =  dao.add(question);
		Assert.assertNotEquals(saveObj.getId(), null);
	}
	
	@Test
	public void createAll()
	{
		Questions question = new Questions();
		question.setName("gggNew");
		question.setInputTypeId(1);
		question.setDependentQuestionOptionId(null);
		List<Questions> list=new ArrayList<>();
		list.add(question);
		try {
			List<Questions> saveList = dao.addAll(list);
			for (Questions entity : saveList) {
				Assert.assertNotEquals(entity.getId(), null);
			}
		} catch (BusinessException e) {
			e.printStackTrace();
		}
	}
}

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
import com.questionnaire.jdbcdao.OptionChoicesDao;
import com.questionnaire.model.OptionChoices;
import com.questionnaire.model.Questions;



@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext
public class TestOptionChoices extends AbstractTestNGSpringContextTests {

	@Autowired
	private OptionChoicesDao dao;
	
	@Test
	public void createOptionChoiceList() throws BusinessException {
		List<OptionChoices> list=new ArrayList<OptionChoices>();
		OptionChoices optionChoice=null;
		for(int i=0;i<3;i++){
			optionChoice = new OptionChoices();
			optionChoice.setOptionChoiceName("Option :"+i);
			optionChoice.setQuestionId(2);
			list.add(optionChoice);
		}
		List<OptionChoices> saveList =  dao.addAll(list);
		for (OptionChoices entity : saveList) {
			Assert.assertNotEquals(entity.getId(), null);
		}
	}

	@Test
	public void createOptionChoice() throws BusinessException {
		OptionChoices optionChoice = new OptionChoices();
		
		optionChoice.setOptionChoiceName("Option New");
		optionChoice.setQuestionId(2);
		OptionChoices saveObj =  dao.add(optionChoice);
		Assert.assertNotEquals(saveObj.getId(), null);
	}
}

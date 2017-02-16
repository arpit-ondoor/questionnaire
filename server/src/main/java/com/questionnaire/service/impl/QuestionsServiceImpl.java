package com.questionnaire.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.questionnaire.commons.exceptions.application.BusinessException;
import com.questionnaire.dto.JsonResponseDto;
import com.questionnaire.dto.OptionChoicesDto;
import com.questionnaire.dto.QuestionWithParentOptionWrapper;
import com.questionnaire.dto.QuestionnaireDto;
import com.questionnaire.dto.QuestionsDto;
import com.questionnaire.jdbcdao.OptionChoicesDao;
import com.questionnaire.jdbcdao.QuestionsDao;
import com.questionnaire.model.OptionChoices;
import com.questionnaire.model.Questions;
import com.questionnaire.service.QuestionsService;

@Transactional
@Service
public class QuestionsServiceImpl implements QuestionsService {

	private Logger logger = LoggerFactory.getLogger(QuestionsServiceImpl.class);

	@Autowired
	private QuestionsDao dao;

	@Autowired
	private OptionChoicesDao optionChoicesDao;

	@Autowired
	private MessageSource messageSource;

	@Transactional(rollbackFor = Exception.class)
	@Override
	public JsonResponseDto createAll(QuestionnaireDto questionnaireDto) throws BusinessException {
		logger.info("Inside method createAll questionnaireDto:" + questionnaireDto);
		try {
			if(questionnaireDto==null||questionnaireDto.getQuestions()==null || questionnaireDto.getQuestions().isEmpty()) {
				logger.error("Inside method createAll, Questionnaire is Empty");
				throw new BusinessException(messageSource.getMessage("questionnaire.empty", null, null));
			}
			return createAll(questionnaireDto.getQuestions());
			
		} catch (BusinessException e) {
			throw e;
		} catch (Exception e) {
			logger.error("Inside method createAll error {}", e);
			throw new BusinessException(messageSource.getMessage("something.went.wrong", null, null));
		}
	}

	private JsonResponseDto createAll(List<QuestionsDto> questionsDtoList) throws BusinessException {

		List<Questions> questions = new ArrayList<>();
		List<OptionChoices> choices = new ArrayList<>();

		addQuestion(questionsDtoList, questions, choices, null);

		dao.addAll(questions);

		addQuestionIds(questions, choices);
		optionChoicesDao.addAll(choices);

		choices.forEach(System.out::println);
		setParentOption(questions);

		return new JsonResponseDto(JsonResponseDto.Status.SUCCESS.getStatus(),messageSource.getMessage("questionnaire.create.success", null, null),null);
	}

	private void addQuestionIds(List<Questions> questions, List<OptionChoices> choices) {
		for (OptionChoices choice : choices) {
			choice.setQuestionId(choice.getQuestions().getId());
		}
	}

	private Questions setQuestion(QuestionsDto dto, OptionChoices parentChoice) {
		Questions question = new Questions();
		question.setName(dto.getName());
		question.setInputTypeId(dto.getTypeId());
		question.setIsChild(dto.getIsChild());
		question.setDependentQuestionOptionId(dto.getDependentQuestionOptionId());
		if (question.getIsChild() && parentChoice != null) {
			question.setParentOption(parentChoice);
		}
		return question;
	}

	private void addQuestion(List<QuestionsDto> questionsDtoList, List<Questions> questions,
			List<OptionChoices> choices, OptionChoices parentChoice) {
		for (QuestionsDto dto : questionsDtoList) {
			Questions question = setQuestion(dto, parentChoice);
			questions.add(question);
			if (dto.getOptions() != null && !dto.getOptions().isEmpty()) {
				addQuestions(dto.getOptions(), question, questions, choices);
			}
		}
	}

	private void addQuestions(List<OptionChoicesDto> optionChoicesDtoList, Questions parent, List<Questions> questions,
			List<OptionChoices> choices) {

		for (OptionChoicesDto dto : optionChoicesDtoList) {
			OptionChoices choice = createChoice(dto, parent);
			choices.add(choice);
			if (dto.getQuestions() != null && !dto.getQuestions().isEmpty()) {
				addQuestion(dto.getQuestions(), questions, choices, choice);
			}
		}
	}

	private OptionChoices createChoice(OptionChoicesDto dto, Questions parent) {
		OptionChoices choice = new OptionChoices();
		choice.setOptionChoiceName(dto.getName());
		choice.setQuestionId(dto.getQuestionId());
		choice.setQuestions(parent);
		return choice;
	}

	private void setParentOption(List<Questions> questions) {
		List<QuestionWithParentOptionWrapper> wrapper = new ArrayList<>();
		for (Questions question : questions) {
			if (question.getIsChild() && question.getParentOption() != null) {
				QuestionWithParentOptionWrapper questionWrapper = new QuestionWithParentOptionWrapper(question.getId(),
						question.getParentOption().getId());
				wrapper.add(questionWrapper);
			}
		}
		dao.setParentOption(wrapper);
	}
}

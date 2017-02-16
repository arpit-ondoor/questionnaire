package com.questionnaire.jdbcdao.impl;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.questionnaire.commons.dao.GenericJdbcDao;
import com.questionnaire.commons.exceptions.application.BusinessException;
import com.questionnaire.commons.generics.dao.RowUnMapper;
import com.questionnaire.jdbcdao.OptionChoicesDao;
import com.questionnaire.jdbcdao.rowmapper.OptionChoicesRowMapper;
import com.questionnaire.model.OptionChoices;

@Repository
public class OptionChoicesDaoImpl extends GenericJdbcDao<OptionChoices>  implements OptionChoicesDao {

	static final String TABLE_NAME = "option_choices";
	static final OptionChoicesRowMapper OptionChoices_ROW_MAPPER = new OptionChoicesRowMapper();
	static final RowUnMapper<OptionChoices> OptionChoices_ROW_UNMAPPER = new RowUnMapper<OptionChoices>() {

		@Override
		public Map<String, Object> mapColumns(OptionChoices entity) {
			Map<String, Object> mapping = new LinkedHashMap<String, Object>();
			mapping.put("id", entity.getId());
			mapping.put("option_choice_name", entity.getOptionChoiceName());
			mapping.put("question_id", entity.getQuestionId());
			return mapping;
		}

		@Override
		public OptionChoices setId(OptionChoices entity, Object id) {
			entity.setId((Integer)id);
			return entity;
		}
	};
	
	public OptionChoicesDaoImpl() {
		super(TABLE_NAME,OptionChoices.class,OptionChoices_ROW_UNMAPPER, "id", OptionChoices_ROW_MAPPER);
	}


	@Override
	public OptionChoices add(OptionChoices optionChoice) throws BusinessException {
		
		return create(optionChoice);
	}


	@Override
	public List<OptionChoices> addAll(List<OptionChoices> entities) throws BusinessException {
		return createAll(entities);
	}



}

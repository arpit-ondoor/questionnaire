package com.questionnaire.jdbcdao.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.questionnaire.commons.dao.GenericJdbcDao;
import com.questionnaire.commons.exceptions.application.BusinessException;
import com.questionnaire.commons.generics.dao.RowUnMapper;
import com.questionnaire.jdbcdao.InputTypesDao;
import com.questionnaire.jdbcdao.rowmapper.InputTypesRowMapper;
import com.questionnaire.model.InputTypes;

@Repository
public class InputTypesDaoImpl extends GenericJdbcDao<InputTypes> implements InputTypesDao {

	static final String TABLE_NAME = "input_types";
	static final InputTypesRowMapper InputTypes_ROW_MAPPER = new InputTypesRowMapper();
	static final RowUnMapper<InputTypes> InputTypes_ROW_UNMAPPER = new RowUnMapper<InputTypes>() {
		@Override
		public Map<String, Object> mapColumns(InputTypes entity) {
			Map<String, Object> mapping = new LinkedHashMap<String, Object>();
			mapping.put("id", entity.getId());
			mapping.put("input_type_name", entity.getInputTypeName());
			mapping.put("display_value", entity.getDisplayValue());
			return mapping;
		}

		@Override
		public InputTypes setId(InputTypes entity, Object id) {
			entity.setId((Integer)id);
			return entity;
		}
	};

	public InputTypesDaoImpl() {
		super(TABLE_NAME, InputTypes.class, InputTypes_ROW_UNMAPPER, "id", InputTypes_ROW_MAPPER);
	}

	@Override
	public List<InputTypes> getAll() throws BusinessException {
		return  findAll();
	}
}

package com.questionnaire.jdbcdao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.questionnaire.commons.dao.GenericJdbcDao;
import com.questionnaire.commons.exceptions.application.BusinessException;
import com.questionnaire.commons.generics.dao.RowUnMapper;
import com.questionnaire.dto.QuestionWithParentOptionWrapper;
import com.questionnaire.jdbcdao.QuestionsDao;
import com.questionnaire.jdbcdao.rowmapper.QuestionsRowMapper;
import com.questionnaire.model.Questions;

@Repository
public class QuestionsDaoImpl extends GenericJdbcDao<Questions> implements QuestionsDao {

	static final String TABLE_NAME = "questions";
	static final QuestionsRowMapper Question_ROW_MAPPER = new QuestionsRowMapper();
	static final RowUnMapper<Questions> Question_ROW_UNMAPPER = new RowUnMapper<Questions>() {

		@Override
		public Map<String, Object> mapColumns(Questions entity) {
			Map<String, Object> mapping = new LinkedHashMap<String, Object>();
			mapping.put("id", entity.getId());
			mapping.put("question_name", entity.getName());
			mapping.put("dependent_question_option_id", entity.getDependentQuestionOptionId());
			mapping.put("input_type_id", entity.getInputTypeId());
			mapping.put("child", entity.getIsChild());
			return mapping;
		}

		@Override
		public Questions setId(Questions entity, Object id) {
			entity.setId((Integer) id);
			return entity;
		}

	};

	public QuestionsDaoImpl() {
		super(TABLE_NAME, Questions.class, Question_ROW_UNMAPPER, "id", Question_ROW_MAPPER);
	}

	@Override
	public Questions add(Questions question) throws BusinessException {
		return create(question);
	}

	@Override
	public List<Questions> addAll(List<Questions> entities) throws BusinessException {
		System.out.println("inside dao one");
		return createAll(entities);
	}

	@Override
	public void setParentOption(List<QuestionWithParentOptionWrapper> wrapper) {
		String sql = "update  questions set dependent_question_option_id=? where id=?";
		getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				ps.setInt(1, wrapper.get(i).getParentOptionId());
				ps.setInt(2, wrapper.get(i).getQuestionId());
			}

			@Override
			public int getBatchSize() {
				return wrapper.size();
			}

		});
	}

}

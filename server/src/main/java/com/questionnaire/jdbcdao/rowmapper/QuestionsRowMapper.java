package com.questionnaire.jdbcdao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.questionnaire.model.Questions;

public class QuestionsRowMapper implements RowMapper<Questions> {

	@Override
	public Questions mapRow(ResultSet rs, int rowNum) throws SQLException {
		Questions question = new Questions();
		question.setId(rs.getInt("id"));
		question.setName(rs.getString("question_name"));
		question.setDependentQuestionOptionId(rs.getInt("dependent_question_option_id"));
		question.setInputTypeId(rs.getInt("input_type_id"));
		question.setIsChild(rs.getBoolean("child"));
		return question;
	}
}

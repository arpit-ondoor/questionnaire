package com.questionnaire.jdbcdao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.questionnaire.model.OptionChoices;

public class OptionChoicesRowMapper implements RowMapper<OptionChoices> {

	@Override
	public OptionChoices mapRow(ResultSet rs, int rowNum) throws SQLException {
		OptionChoices optionChoice = new OptionChoices();
		System.out.println();
		optionChoice.setId(rs.getInt("id"));
		optionChoice.setOptionChoiceName(rs.getString("option_choice_name"));
		optionChoice.setQuestionId(rs.getInt("question_id"));
		return optionChoice;
	}
}

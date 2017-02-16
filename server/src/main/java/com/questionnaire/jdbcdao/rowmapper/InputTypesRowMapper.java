package com.questionnaire.jdbcdao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.questionnaire.model.InputTypes;

public class InputTypesRowMapper implements RowMapper<InputTypes> {

	@Override
	public InputTypes mapRow(ResultSet rs, int rowNum) throws SQLException {
		InputTypes inputTypes = new InputTypes();
		inputTypes.setId(rs.getInt("id"));
		inputTypes.setInputTypeName(rs.getString("input_type_name"));
		inputTypes.setDisplayValue(rs.getString("display_value"));
		return inputTypes;
	}

}
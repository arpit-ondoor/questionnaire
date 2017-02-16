package com.questionnaire.commons.generics.dao;

import java.util.Map;

public interface RowUnMapper<E> {
	Map<String, Object> mapColumns(E entity);
	E setId(E entity, Object id);
}
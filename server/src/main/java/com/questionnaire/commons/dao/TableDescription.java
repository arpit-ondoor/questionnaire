package com.questionnaire.commons.dao;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.util.StringUtils;

/**
 * @author Arpit A
 * @since 01/13/16, 01:13 PM
 */
public class TableDescription {

	private final String name;
	private final List<String> idColumns;
	private final String fromClause;

	public TableDescription(String name, String fromClause, String... idColumns) {
//		Assert.notNull(name);
//		Assert.notNull(idColumns);
//		Assert.isTrue(idColumns.length > 0, "At least one primary key column must be provided");
System.out.println("TD idColumns :"+idColumns);
		this.name = name;
		this.idColumns = Collections.unmodifiableList(Arrays.asList(idColumns));
		if (StringUtils.hasText(fromClause)) {
			this.fromClause = fromClause;
		} else {
			this.fromClause = name;
		}
	}

	public TableDescription(String name, String idColumn) {
		this(name, null, idColumn);
	}

	public String getName() {
		return name;
	}

	public List<String> getIdColumns() {
		return idColumns;
	}

	public String getFromClause() {
		return fromClause;
	}
}
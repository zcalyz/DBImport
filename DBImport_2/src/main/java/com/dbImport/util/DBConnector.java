package com.dbImport.util;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class DBConnector {
	JdbcTemplate jdbc;

	public DBConnector(DataSource dataSource) {
		this.jdbc = new JdbcTemplate(dataSource);
	}

	public void execute(String sql) {
		jdbc.execute(sql);
	}

	public List<Map<String, Object>> queryForList(String sql) {
		return jdbc.queryForList(sql);
	}

}

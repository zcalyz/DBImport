package com.dbImport.config;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class DataSourceConfig {
	static DriverManagerDataSource dmdsForBroker = null;

	public static DataSource getMySqlDataSource() {
		if (dmdsForBroker != null)
			return dmdsForBroker;

		dmdsForBroker = new DriverManagerDataSource();
		dmdsForBroker.setDriverClassName("com.mysql.jdbc.Driver");
		StringBuilder builder = new StringBuilder();
		
		String ip = "10.10.105.112";
		String port = "3306";
		
		String database = "cf_db_18e1b1ff";		
		builder.append("jdbc:mysql://")
				.append(ip + ":")
				.append(port + "/")
				.append(database);
		
//		System.out.println(builder.toString());
		dmdsForBroker.setUrl(builder.toString());
		dmdsForBroker.setUsername("cf_user_f079d13a");
		dmdsForBroker.setPassword("cf_passwd_f079d13a");

		return dmdsForBroker;
	}
}
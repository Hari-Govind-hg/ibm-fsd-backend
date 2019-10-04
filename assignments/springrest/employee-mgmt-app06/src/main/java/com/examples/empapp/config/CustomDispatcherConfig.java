package com.examples.empapp.config;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.examples.empapp.dao.EmployeeDAO;
import com.examples.empapp.model.Employee;
import com.examples.empapp.service.EmployeeService;
import com.mysql.cj.jdbc.MysqlDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.examples.empapp")
public class CustomDispatcherConfig {
	@Bean
	public EmployeeService eserv() {
		return new EmployeeService();
	}
	
	@Bean
	public EmployeeDAO dao() {
		return new EmployeeDAO();
	}
	@Bean
	public Employee emp() {
		return new Employee();
	}
	
	@Bean
	public MysqlDataSource dataSource() {
	MysqlDataSource dataSource = new MysqlDataSource();
	dataSource.setDatabaseName("jdbctraining");
	dataSource.setUser("training");
	dataSource.setPassword("training");
	dataSource.setServerName("localhost");
	return dataSource;
	}
	
	@Bean
	public Connection conn() {
		Connection conn=null;
		try {
			conn=dataSource().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}

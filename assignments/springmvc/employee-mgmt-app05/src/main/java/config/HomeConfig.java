package config;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.mysql.cj.jdbc.MysqlDataSource;

import dao.EmployeeDAO;
import model.Employee;
import services.EmployeeService;

@Configuration
@EnableWebMvc
public class HomeConfig {
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

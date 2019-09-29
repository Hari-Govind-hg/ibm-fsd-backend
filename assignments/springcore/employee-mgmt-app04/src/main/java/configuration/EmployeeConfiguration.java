package configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import services.EmployeeService;
import model.Employee;
import dao.EmployeeDAO;

@Configuration
public class EmployeeConfiguration {
	
	@Bean
	@Lazy
	public Employee empnew() {
		return new Employee();
	}
	
	@Lazy
	@Bean
	public EmployeeService eserv() {
		return new EmployeeService();
	}
	
	@Lazy
	@Bean
	public EmployeeDAO dao() {
		return new EmployeeDAO();
	}
}

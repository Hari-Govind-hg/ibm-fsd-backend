package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;


import model.Employee;
import com.mysql.cj.jdbc.MysqlDataSource;
import configuration.EmployeeConfiguration;

public class EmployeeDAO implements IEmployeeDAO{	
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int flag;
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(EmployeeConfiguration.class);
		HashMap<Integer,Employee> empMap1=new HashMap<Integer,Employee>();
		Scanner sc = new Scanner(System.in);
		public EmployeeDAO(){
			if(flag==0) {
					try{MysqlDataSource dataSource = new MysqlDataSource();
					dataSource.setDatabaseName("jdbctraining");
					dataSource.setUser("training");
					dataSource.setPassword("training");
					dataSource.setServerName("localhost");

					// STEP 3: Open a connection
					System.out.println("Connecting to database...");
					conn = dataSource.getConnection();
					conn.setAutoCommit(false); // enable transaction

					System.out.println("Connection estabilished: " + conn);
					
//					// STEP 4: Execute a query
//					System.out.println("Creating statement...");
//					stmt = conn.createStatement();
					}
					catch(SQLException se) {
						se.printStackTrace();
					}
					flag=1;
					}
			else if(flag!=0) {
				System.out.println("Connection already established");
			}
					}
		
		
		public void addEmpDb(Employee e){
		try {
				String insertQueryForPrepareStmt = "INSERT INTO employee ( name, age, designation, department, country) VALUES ( ?, ?, ?, ?, ?)";
				try {
				pstmt = conn.prepareStatement(insertQueryForPrepareStmt);
				pstmt.setString(1, e.getEmpName());
				pstmt.setInt(2, e.getAge());
				pstmt.setString(3, e.getDesig());
				pstmt.setString(4, e.getDept());
				pstmt.setString(5, Integer.toString(e.getSalary()));
				int insertCount = pstmt.executeUpdate();
				pstmt.close();
				System.out.println(insertCount + " Employee(s) inserted");} catch (SQLException e1) {
					e1.printStackTrace();
				}
			conn.commit();
		}catch (SQLException se) {
			se.printStackTrace();
		}
		System.out.println("Goodbye!");

	}
		
	public void viewEmpDb(int id) {
		String selectQuery = "Select * FROM employee WHERE id = ?";
		try {
			pstmt = conn.prepareStatement(selectQuery);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			Employee e = (Employee)ctx.getBean("empnew");
			while(rs.next())
			{
			e.setEmpId(rs.getInt("id"));
			e.setEmpName(rs.getString("name"));
			e.setAge(rs.getInt("age"));
			e.setDept( rs.getString("department"));
			e.setDesig( rs.getString("designation"));
			e.setSalary(Integer.parseInt(rs.getString("country")));
			}
			e.printDetails();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
		public void delEmpDb(int empid) {
			String deleteQuery = "DELETE FROM employee WHERE id = ?";
				try{System.out.println("Entered deletedb function");
				pstmt = conn.prepareStatement(deleteQuery);
				System.out.println("prepared statement ready");
				pstmt.setInt(1, empid);
				System.out.println(pstmt);
				int deleteCount = pstmt.executeUpdate();
				System.out.println("Setted");
				pstmt.close();
				System.out.println(deleteCount + " Employee(s) deleted");
				conn.commit();
			}catch(SQLException se) {
				se.printStackTrace();
			}
		}


		public ArrayList<Employee> viewAllEmpDb() {
			String selectQuery = "Select * FROM employee";
			ArrayList<Employee> eList = new ArrayList<Employee>();
			try {
				pstmt = conn.prepareStatement(selectQuery);
				rs = pstmt.executeQuery();
				while(rs.next())
				{Employee e = new Employee();
				e.setEmpId(rs.getInt("id"));
				e.setEmpName(rs.getString("name"));
				e.setAge(rs.getInt("age"));
				e.setDept( rs.getString("department"));
				e.setDesig( rs.getString("designation"));
				e.setSalary(Integer.parseInt(rs.getString("country")));
				eList.add(e);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return eList;
		}
		
		public void updateEmpDb(int id) {
			Employee e = (Employee)ctx.getBean("empnew");
				System.out.println("Enter the Id");
				e.setEmpId(sc.nextInt());
				System.out.println("Enter the Name");
				e.setEmpName(sc.next());
				System.out.println("Enter the Age");
				e.setAge(sc.nextInt());
				System.out.println("Enter the Designation");
				e.setDesig(sc.next());
				System.out.println("Enter the Department");
				e.setDept(sc.next());
				System.out.println("Enter the Salary");
				e.setSalary(sc.nextInt());
				
				try{String updateQuery = "UPDATE employee SET name = ?, age = ?, designation = ?, department = ?, country=? WHERE id = ?";
				System.out.println("entered database update section");
				pstmt = conn.prepareStatement(updateQuery);
				pstmt.setString(1, e.getEmpName());
				pstmt.setInt(2, e.getAge());
				pstmt.setString(3, e.getDesig());
				pstmt.setString(4, e.getDept());
				pstmt.setString(5, Integer.toString(e.getSalary()));
				pstmt.setInt(6, id);
				int deleteCount= pstmt.executeUpdate();
				pstmt.close();
				System.out.println("Updated Successfully");
				conn.commit();
				}catch(SQLException k) {
					k.printStackTrace();
				}
		}
}

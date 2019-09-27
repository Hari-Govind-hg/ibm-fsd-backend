package com.examples.empapp.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.examples.empapp.model.*;

public interface IEmployeeDAO {
		public void addEmpDb(Employee e);
		public Employee viewEmpDb(int id);
		public void delEmpDb(int id);
		public ArrayList<Employee> viewAllEmpDb();
		public void updateEmpDb(Employee e);
}

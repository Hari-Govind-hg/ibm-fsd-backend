package com.Java.Assignment1_jdbc.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.Java.Assignment1_jdbc.model.*;

public interface IEmployeeDAO {
		public void addEmpDb(Employee e);
		public void viewEmpDb(int id);
		public void delEmpDb(int id);
		public ArrayList<Employee> viewAllEmpDb();
		public void updateEmpDb(int id);
}

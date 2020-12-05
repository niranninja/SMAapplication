package test;

import  org.junit.Test;
import dao.IEmployeeDao;
import daoimpl.EmployeeDao;
import model.Employee;

public class Testclass {
	@Test
	public void testgetEmployeeById(){
		Employee empActual=new Employee();
		Employee empExpected=new Employee();
		empActual=empDao.getEmployeeById();
	}

}

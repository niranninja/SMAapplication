package controller;
import java.io.*;
import model.Employee;
import java.sql.*;
import java.util.Iterator;
import java.util.List;
import dao.IEmployeeDao;
import daoimpl.EmployeeDao;


public class Employeecontroller {
	IEmployeeDao empDao=null;
	public Employeecontroller() throws ClassNotFoundException, SQLException{
		empDao=new EmployeeDao();
	}
	
	public void addEmployee(){
		Employee emp=new Employee();
		try {
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter Your First Name: ");
		emp.setFirstName(reader.readLine());
		System.out.println("Enter Your Last Name: ");
		emp.setLastName(reader.readLine());
		System.out.println("Enter Your User ID: ");
		emp.setUserId(reader.readLine());
		System.out.println("Enter Your Password: ");
		emp.setPassword(reader.readLine());
		System.out.println("Enter Your Role: ");
		String role=reader.readLine();
		emp.setRole(role);
		System.out.println("Enter Your Gender: ");
		emp.setGender(reader.readLine());
		if(role.equals("HRA")) {
			emp.setActive("Active");
		}
		else {
			emp.setActive("Deactivate");
		}
		//calling  dao method for insert record
		empDao.addEmployee(emp);
	}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	public void getAllEmployees() {
		
		List<Employee> allEmpList=empDao.getAllEmployees();
		for(Employee emp:allEmpList) {
			System.out.println(emp);
		}
	}
	public void getEmployeeById() {
		try {
			
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		int id;
		System.out.print("Enter the EmployeeId whose record you want to access: ");
		id=Integer.parseInt(reader.readLine());
		Employee emp=empDao.getEmployeeById(id);
		System.out.println(emp);
		
		}
		catch(IOException ex){
			System.out.println(ex.getMessage());
			
		}
	}
	public void updateEmployee() {
		try {
			
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			String FirstName, LastName, Password, confirmPassword;
			System.out.print("Enter the EmployeeId whose record you want to Update: ");
			id=Integer.parseInt(reader.readLine());
			Employee emp=empDao.getEmployeeById(id);
			System.out.println("Enter Your New Password: ");
			Password=reader.readLine();
			System.out.print("Re-Enter Your New Password");
			confirmPassword=reader.readLine();
			if(Password.equals(confirmPassword)) {
				emp.setPassword(Password);
				empDao.updateEmployee(emp);
			}
			else {
				System.out.println("It Seems you have Entered Different Password !!!");
			}
			
		}
		catch(IOException ex){
			System.out.println(ex.getMessage());
			
		}
	}
	public void deactivateEmployee() {
		
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			System.out.println("Enter the Employee Id you want to Deactivate: ");
			id=Integer.parseInt(reader.readLine());
			Employee emp=empDao.getEmployeeById(id);
			empDao.deactivateEmployee(emp);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	public void deleteEmployee() {
		
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			System.out.println("Enter the Employee ID you wish to Delete: ");
			id=Integer.parseInt(reader.readLine());
			empDao.deleteEmployee(id);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
}

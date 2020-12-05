package daoimpl;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import config.Jdbcconnection;
import dao.IEmployeeDao;
import model.Employee;

public class EmployeeDao implements IEmployeeDao{
	
Connection conn=null;
public EmployeeDao() throws ClassNotFoundException, SQLException {
	//Opened connection
	conn=Jdbcconnection.getDBConnection();
}
	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> allEmpList=new ArrayList<Employee>();
		try {
			Statement stmt=conn.createStatement();
			ResultSet rst=stmt.executeQuery("Select * from Employee");
			if(rst!=null) {
				Employee emp=null;
				while(rst.next()) {
					emp=new Employee();
					emp.setEmpId(rst.getInt(1));
					emp.setFirstName(rst.getString(2));
					emp.setLastName(rst.getString(3));
					emp.setUserId(rst.getString(4));
					emp.setPassword(rst.getString(5));
					emp.setRole(rst.getString(6));
					emp.setGender(rst.getString(7));
					emp.setActive(rst.getString(8));
					allEmpList.add(emp);
				}
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
			
		}
		return allEmpList;
		
	}

	@Override
	public void addEmployee(Employee emp){
		try {
		//creating prepared statements object by passing query string
		PreparedStatement pst=conn.prepareCall("insert into Employee(FirstName, LastName, UserId, Password, Role, Gender, Active) values (?,?,?,?,?,?,?)");
		pst.setString(1, emp.getFirstName());
		pst.setString(2, emp.getLastName());
		pst.setString(3, emp.getUserId());
		pst.setString(4, emp.getPassword());
		pst.setString(5, emp.getRole());
		pst.setString(6, emp.getGender());
		pst.setString(7, emp.getActive());
		int i=pst.executeUpdate();
		if(i==1){
			System.out.println("1 Record inserted.....");
		}
		else {
			System.out.println("Insertion Failed.....");
		}
	}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
			
		}
	}	
	@Override
	public Employee getEmployeeById(int id) {
		Employee emp=new Employee();
		try {
			PreparedStatement pst=conn.prepareStatement("Select * from Employee where empId=?");
			pst.setInt(1, id);
			ResultSet rst=pst.executeQuery();
			if(rst!=null) {
				emp.setEmpId(rst.getInt(1));
				emp.setFirstName(rst.getString(2));
				emp.setLastName(rst.getString(3));
				emp.setUserId(rst.getString(4));
				emp.setPassword(rst.getString(5));
				emp.setRole(rst.getString(6));
				emp.setGender(rst.getString(7));
				emp.setActive(rst.getString(8));
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return emp;
	}

	@Override
	public void updateEmployee(Employee emp) {
		
		try {
		PreparedStatement pst=conn.prepareStatement("update Employee set Password=? where empId=?");
		pst.setString(1, emp.getFirstName());
		pst.setString(2, emp.getLastName());
		pst.setString(3, emp.getPassword());
		pst.setInt(4, emp.getEmpId());
		int i=pst.executeUpdate();
		if(i==1) {
			System.out.println("1 Record Updated...");
		}
		else {
			System.out.println("Record Updation Failed...");
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
	}

	@Override
	public void deactivateEmployee(Employee emp) {
		
		try {
		PreparedStatement pst=conn.prepareStatement("update Employee set Active=? where empId=?");
				pst.setString(1, "Deactive");
				pst.setInt(2, emp.getEmpId());
				int i=pst.executeUpdate();
				if(i==1) {
					System.out.println("Your Employee Deactivated... ");
				}
				else {
					System.out.println("Record Updation Failed...");
				}
		}
				catch(SQLException ex) {
					System.out.println(ex.getMessage());
				}
				
	}

	@Override
	public void deleteEmployee(int id) {
		
		try {
			PreparedStatement pst=conn.prepareStatement("delete from Employee where empId=?");
			pst.setInt(1, id);
			int i=pst.executeUpdate();
			if(i==1) {
				System.out.println("Employee Deleted...");
			}
			else {
				System.out.println("Deletion Failed...");
			}
		}
			catch(SQLException ex){
				System.out.println(ex.getMessage());
				
			}
		}
	}
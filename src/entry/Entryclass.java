package entry;

import java.sql.SQLException;

import config.Jdbcconnection;
import controller.Employeecontroller;

public class Entryclass {
	public void testConnection() throws ClassNotFoundException, SQLException {
		if(Jdbcconnection.getDBConnection().isClosed()) {
			System.out.println("Connection is Closed");
		}
		else {
			System.out.println("Connection is Opened");
		}
		
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//Entryclass entr=new Entryclass();
		//entr.testConnection();
		Employeecontroller empController=new Employeecontroller();
		System.out.println("Enter Employee Detail: ");
		empController.addEmployee();
		System.out.println("Following are all Employees Detail: ");
		empController.getAllEmployees();
		

	}

}

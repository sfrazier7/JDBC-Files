import java.sql.*;

public class jdbcTest2 {
	
	public static void main(String[] args) throws Exception {
		
		Connection connect = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
			//Connection to DB
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useSSL=false", "root", "SataniaShiraha7!");
			System.out.println("Database connected.\n");
			
			//Statement
			statement = connect.createStatement();
	
			//Inserting a Employee into DB table
			System.out.println("Adding a new employee to db");
			
			int rowsAffected = statement.executeUpdate("insert into employees " + "(last_name, first_name, email, department, salary) "
			+ "values " + "('Wright', 'Eric', 'eric.wright@foo.com', 'HR', 33000.00)");
			
			//Gets List of Employees to Verify Change
			resultSet = statement.executeQuery("select * from employees order by last_name");
			
			//Processes Result Set
			while (resultSet.next()) {
				System.out.println(resultSet.getString("last_name") + ", " + resultSet.getString("first_name"));
			}
	}

}

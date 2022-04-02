import java.sql.*;

public class jdbcTest {
	
	public static void main(String[] args) throws Exception {
		
		Connection connect = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
			//Connection to DB
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useSSL=false", "root", "SataniaShiraha7!");
			System.out.println("Database connected.\n");
			
			//Statement
			statement = connect.createStatement();
			
			//SQL Query Execution
			resultSet = statement.executeQuery("select * from employees");
			
			//Processes the result of set
			while(resultSet.next()) {
				System.out.println(resultSet.getString("last_name") + ", " + resultSet.getString("first_name"));
			}
	}
}

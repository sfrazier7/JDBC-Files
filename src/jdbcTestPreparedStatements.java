import java.sql.*;

public class jdbcTestPreparedStatements {
	
	public static void main(String[] args) throws Exception {
		
		Connection connect = null;
		PreparedStatement prepStatement = null;
		ResultSet resultSet = null;
		
			//Connection to DB
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useSSL=false", "root", "SataniaShiraha7!");
			System.out.println("Database connected.\n");
			
			//Prepare Statement
			prepStatement = connect.prepareStatement("select * from employees where salary > ? and department=?");
			
			//SQL Parameters
			prepStatement.setDouble(1, 80000);
			prepStatement.setString(2, "legal");
			
			resultSet = prepStatement.executeQuery();
			
			//Processes the result of set
			while(resultSet.next()) {
				System.out.println(resultSet.getString("last_name") + ", " + resultSet.getString("first_name") + ", " 
			+ resultSet.getDouble("salary"));
			}
	}
}

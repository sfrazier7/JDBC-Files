import java.sql.*;

public class jdbcTestPreparedStatements {
	
	public static void main(String[] args) throws Exception {
		
		
		PreparedStatement prepStatement = null;
		ResultSet resultSet = null;
		
		//Connection to DB
		ConnectionFile conn = new ConnectionFile();
		conn.getConn();
			
			//Prepare Statement
			prepStatement = conn.getConn().prepareStatement("select * from employees where salary > ? and department=?");
			
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

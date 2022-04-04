import java.sql.*;

public class jdbcTest {
	
	public static void main(String[] args) throws Exception {
		
		Statement statement = null;
		ResultSet resultSet = null;
		
		//Connection to DB
		ConnectionFile conn = new ConnectionFile();
		conn.getConn();
	
		//Statement
		statement = conn.getConn().createStatement();
		
		//SQL Query Execution
		resultSet = statement.executeQuery("select * from employees");
		
		//Processes the result of set
		while(resultSet.next()) {
		System.out.println(resultSet.getString("last_name") + ", " + resultSet.getString("first_name"));
    }
	}
}

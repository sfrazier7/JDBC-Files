import java.sql.*;

public class jdbcTest3 {
	
	public static void main(String[] args) throws Exception {
		
		
		Statement statement = null;
		ResultSet resultSet = null;
		
			//Connection to DB
			ConnectionFile conn = new ConnectionFile();
			conn.getConn();
			
			//Statement
			statement = conn.getConn().createStatement();
			
			System.out.println("Before Update");
			displayEmployee(conn.getConn(), "John", "Doe");
			
			//Updating Email Info
			int rowsAffected = statement.executeUpdate("update employees " + "set email='john.doe@luv2code.com' " +
			"where last_name='Doe' and first_name = 'John'");
			
			System.out.println("After Update");
			displayEmployee(conn.getConn(), "John", "Doe");
		
			
	}
	
	private static void displayEmployee(Connection myConn, String firstName, String lastName) throws SQLException {
		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		try {
			// Prepare statement
			myStmt = myConn
					.prepareStatement("select last_name, first_name, email from employees where last_name=? and first_name=?");

			myStmt.setString(1, lastName);
			myStmt.setString(2, firstName);
			
			// Execute SQL query
			myRs = myStmt.executeQuery();

			// Process result set
			while (myRs.next()) {
				String theLastName = myRs.getString("last_name");
				String theFirstName = myRs.getString("first_name");
				String email = myRs.getString("email");
			
				System.out.printf("%s %s, %s\n", theFirstName, theLastName, email);
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			close(myStmt, myRs);
		}

	}
	
	private static void close(Connection myConn, Statement myStmt,
			ResultSet myRs) throws SQLException {
		if (myRs != null) {
			myRs.close();
		}

		if (myStmt != null) {
			myStmt.close();
		}

		if (myConn != null) {
			myConn.close();
		}
	}
	
	private static void close(Statement myStmt, ResultSet myRs)
			throws SQLException {

		close(null, myStmt, myRs);
	}	
}

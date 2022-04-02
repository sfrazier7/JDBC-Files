import java.sql.*;

public class jdbcTest3 {
	
	public static void main(String[] args) throws Exception {
		
		Connection connect = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
			//Connection to DB
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useSSL=false", "root", "SataniaShiraha7!");
			System.out.println("Database connected.\n");
			
			//Statement
			statement = connect.createStatement();
			
			System.out.println("Before Update");
			displayEmployee(connect, "John", "Doe");
			
			//Updating Email Info
			int rowsAffected = statement.executeUpdate("update employees " + "set email='john.doe@luv2code.com' " +
			"where last_name='Doe' and first_name = 'John'");
			
			System.out.println("After Update");
			displayEmployee(connect, "John", "Doe");
		
			
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

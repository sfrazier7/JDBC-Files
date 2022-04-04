import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ResultSetMetaData {

	public static void main(String[] args) throws Exception {
		
		Connection conn = null;
		Statement state = null;
		ResultSet rSet = null;
		
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useSSL=false", "root", "serverpassword");
		System.out.println("Database connected.\n");
		
		state = conn.createStatement();
		rSet = state.executeQuery("select id, last_name, first_name, salary from employees");
		
		java.sql.ResultSetMetaData rsMetaData = rSet.getMetaData();
		
		int columnCount = rsMetaData.getColumnCount();
		System.out.println("Column Count: " + columnCount + "\n");
		
		for (int column=1; column <= columnCount; column++) {
			System.out.println("Column name: " + rsMetaData.getColumnName(column));
			System.out.println("Column type name: " + rsMetaData.getColumnTypeName(column));
			System.out.println("Is Nullable: " + rsMetaData.isNullable(column));
			System.out.println("Is Auto Increment: " + rsMetaData.isAutoIncrement(column) + "\n");
			
		}

	}

	
	
}

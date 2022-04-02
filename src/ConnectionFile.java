import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class ConnectionFile {

	public static void main(String[] args) throws SQLException, FileNotFoundException, IOException {
		
		Connection conn = null;
		Statement state = null;
		ResultSet rset = null;
		
		Properties props = new Properties();
		props.load(new FileInputStream("C:\\Users\\ShafirFrazier\\Documents\\demo.properties.txt"));
		
		String user = props.getProperty("user");
		String password = props.getProperty("password");
		String dbURL = props.getProperty("dbURL");
		
		System.out.println("Connecting to database...");
		System.out.println("Database URL..." + dbURL);
		System.out.println("Connecting to database..." + user);
		
		conn = DriverManager.getConnection(dbURL, user, password);
		System.out.println("\nConnection successful.");

	}

}

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class DatabaseMetaData {

	public static void main(String[] args) throws Exception {
		
		ResultSet resultSet = null;
		String catalog = null;
		String schemaPattern = null;
		String tableNamePattern = null;
		String columnNamePattern = null;
		String[] types = null;
		
		ConnectionFile conn = new ConnectionFile();
		conn.getConn();
		
		java.sql.DatabaseMetaData dbMetaData = conn.getConn().getMetaData();
		
		//DB Info
		System.out.println("Product name: " + dbMetaData.getDatabaseProductName());
		System.out.println("Product version: " + dbMetaData.getDatabaseProductVersion());
		System.out.println();
		
		//JDBC Driver Info
		System.out.println("JDBC Driver name: " + dbMetaData.getDriverName());
		System.out.println("JDBC Driver version: " + dbMetaData.getDriverVersion());
		
		//List of Tables
		System.out.println("List of Tables");
		System.out.println("--------------");
		
		resultSet = dbMetaData.getTables(catalog, schemaPattern, tableNamePattern, types);
		
		while(resultSet.next()) {
			System.out.println(resultSet.getString("TABLE_NAME"));
		}
		
		//List of Columns
		System.out.println("\nList of Columns");
		System.out.println("-----------------");
		
		resultSet = dbMetaData.getColumns(catalog, schemaPattern, "employees", columnNamePattern);
		
		while(resultSet.next()) {
			System.out.println(resultSet.getString("COLUMN_NAME"));
		}
		
		conn.getConn().close();;
		resultSet.close();
			

	}

}

/**
 * 
 */
package fr.epita.iam.test.database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Ejuma
 *
 */
public class TestDatabase {

	/**
	 * @param args String user and String pasword
	 * @throws SQLException this is thrown in case of errors in the connection to the db 
	 */
	public static void main(String[] args) throws SQLException {
		String connectionString = "jdbc:derby://localhost:1527/demo";
		String user = "EJUMA";
		String password = "EJUMA";
		
		Connection connection = DriverManager.getConnection(connectionString, user, password);
		
		PreparedStatement preparedStatement = connection.prepareStatement("insert into IDENTITIES (IDENTITY_DISPLAYNAME, IDENTITY_EMAIL, IDENTITY_BIRTHDATE) values(?, ?, ?)");
		
		preparedStatement.setString(1, "Quentin");
		preparedStatement.setString(2, "qdeca@qdeca.com");
		preparedStatement.setDate(3,  new Date(new java.util.Date().getTime()));
		preparedStatement.execute();
		preparedStatement.close();
		
		PreparedStatement selectAllStatement = connection.prepareStatement("select * from IDENTITIES");
		
		ResultSet results = selectAllStatement.executeQuery();
		
		
		while (results.next()){
			String displayName = results.getString("IDENTITY_DISPLAYNAME");
			String email = results.getString("IDENTITY_EMAIL");
			Date birthDate = results.getDate("IDENTITY_BIRTHDATE");
			
			System.out.println(displayName + " - " + email + " - " + birthDate );
			
		}
		
		selectAllStatement.close();
		results.close();
		connection.close();
		
	}

}

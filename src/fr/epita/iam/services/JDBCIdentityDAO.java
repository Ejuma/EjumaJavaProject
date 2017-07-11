package fr.epita.iam.services;
/**
 * 
 * @author Ejuma
 *
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.epita.iamcore.datamodel.Identity;
import fr.epita.iam.Exception.DaoDeleteException;
import fr.epita.iam.Exception.DaoSaveException;
import fr.epita.iam.Exception.DaoSearchException;
import fr.epita.iam.Exception.DaoUpdateException;

/**
 * 
 * This  class handles all the operations to the database. For the cases update and delete,
 * it uses the search method to search through the database using a criteria. in this case
 * uid (Identities), then executes the operation.
 * 
 * <pre>
 *  JDBCIdentityDAO to the database = new JDBCIdentityDAO();
 *  
 *  // this is used to save a identities to the database
 *  dao.save(new Identity(...));
 *  
 *  //this is used to search the database based on a criteria,  (qbe)  
 *  dao.search(new Identity(...);
 *  
 *  //this is used to update records in  the database based on  user id,    
 *  dao.update(new Identity(...);
 *  
 *  //this is used to delete record in  the database based on user id,  
 *  dao.delete(new Identity(...);
 * </pre>
 * 
 * <b>warning</b> this class is dealing with database connections, so remember to
 * release it through the {@link #releaseResources()}
 * 
 * @author Ejuma
 *
 */
	
public class JDBCIdentityDAO implements CommonDAO {

	private Connection connection;
	private String displayName;
	private String email;
	private String uid;
	

	/**
	 * @throws SQLException
	 * this creates the connection to the database to be used
	 */
	public JDBCIdentityDAO() throws SQLException {
		this.connection = DriverManager.getConnection("jdbc:derby://localhost:1527/sample;create=true", "IAM", "123");
	}
	
	/**
	 * This is the search method, it will search if the identity exist and return a list of result
	 * @param identity is the identity to search
	 * @throws DAOSearchException if there is any search error occurs
	 * @return List of  identities searched
	 */
	public List<Identity> search(Identity criteria) throws DaoSearchException {
		List<Identity> returnedList = new ArrayList<Identity>();
		try {
			PreparedStatement operationStatement = this.connection.prepareStatement("SELECT * from IDENTITIES ");
			ResultSet results = operationStatement.executeQuery();

			while (results.next()) {
				this.displayName = results.getString("NAME");
				this.uid = results.getString("UID");
				this.email = results.getString("EMAIL");
				returnedList.add(new Identity(displayName, uid, email));

			}
		} catch (SQLException sqle) {
			DaoSearchException daose = new DaoSearchException();
			daose.initCause(sqle);
			throw daose;
		}

		return returnedList;
	}

	
	


	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.epita.iam.services.CommonDAO#update(fr.epita.iam.datamodel.Identity)
	 */
	
	/**
	 * This is the save method,
	 * @param identity is the identity to search
	 * @throws SaveDAOException is thrown if there are errors in the process of saving 
	 * 
	 */
	@Override
	public void save(Identity identity) throws DaoSaveException {
		// TODO Auto-generated method stub
		try {
			PreparedStatement prepareStatement = this.connection.prepareStatement("INSERT INTO ABC (NAME, EMAIL) VALUES (?,?)");
			prepareStatement.setString(1, identity.getDisplayname());
			prepareStatement.setString(2, identity.getEmail());
			prepareStatement.execute();
		} catch (SQLException sqle) {
			DaoSaveException exception = new DaoSaveException();
			exception.initCause(sqle);
			exception.setErrorObject(identity);
			throw exception;
		}
	}

	@Override
	
	/**
	 * This is the delete method, it works by searching first the identity to be deleted before deleting
	 * @param identity is the identity to delete
	 * @throws DAODeleteException is run if there are any errors in the process of deleting
	 * 
	 */
	public void delete(Identity identity) throws DaoDeleteException {
		// TODO Auto-generated method stub
		PreparedStatement preparedStatement = null;

		String state = "Delete from ABC "
				        + " Where IDENTITIES = ?";

		try {
			preparedStatement = this.connection.prepareStatement(state);

			preparedStatement.setString(1, identity.getUid());

			// execute update SQL statement
			preparedStatement.execute();

			System.out.println("Record is updated to the database!");

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}
	}
	
	/**
	 * This is the update method, it  works by searching through the database first before updating the required id
	 * @param identity is the identity to be updated
	 * @throws DAOUpdateException is run if there is any error during the saving
	 * 
	 */

	@Override
	public void update(Identity identity) throws DaoUpdateException {
		// TODO Auto-generated method stub
		PreparedStatement preparedStatement = null;

		String updateTableSQL = "Update ABC set NAME = ?, EMAIL = ?"
				                  + " Where IDENTITIES = ?";

		try {
			preparedStatement = this.connection.prepareStatement(updateTableSQL);

			preparedStatement.setString(1, identity.getDisplayname());
			preparedStatement.setString(2, identity.getEmail());
			preparedStatement.setString(3, identity.getUid());

			// execute update SQL statement
			preparedStatement.execute();

			System.out.println("Record is updated to the database!");

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}
	}
}


	

	





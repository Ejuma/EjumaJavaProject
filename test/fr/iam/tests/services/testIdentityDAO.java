package fr.iam.tests.services;

import java.sql.SQLException;
import java.util.List;

import fr.epita.iam.Exception.DaoSaveException;
import fr.epita.iam.Exception.DaoSearchException;

import fr.epita.iam.services.JDBCIdentityDAO;
import fr.epita.iamcore.datamodel.Identity;

public class testIdentityDAO {
	/**
	 * @param args
	 * @throws DaoSaveException 
	 * @throws SQLException 
	 * @throws DaoSearchException 
	 * 
	 */

		public static void main(String[]args) throws DaoSaveException, SQLException, DaoSearchException {
			
				//given the following services
			JDBCIdentityDAO dao = new JDBCIdentityDAO();
			
			// when you call the save method
			List<Identity> identityList = dao.search(null);
			int initialSize = identityList.size();
		
			dao.save((Identity) identityList);
			
			identityList = dao.search(null);
			int finalSize = identityList.size();
			
			
			// then
			// TODO check that the file is getting created
			if (finalSize - initialSize != 1){
				System.out.println("error!");
			}
			
			System.out.println(identityList);
			

		}

	}


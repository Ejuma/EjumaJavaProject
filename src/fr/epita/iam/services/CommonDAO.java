package fr.epita.iam.services;

import java.util.List;

import fr.epita.iam.Exception.DaoDeleteException;
import fr.epita.iam.Exception.DaoSaveException;
import fr.epita.iam.Exception.DaoSearchException;
import fr.epita.iam.Exception.DaoUpdateException;
import fr.epita.iamcore.datamodel.Identity;

/**
 * 
 * @author Ejuma
 *this is a list of classes without any predefined body
 *
 */
public interface CommonDAO {
	
/** 
 * 
 * This class is a common dao for  create class in both fileidentityDAO and JDBCDAO
 * @throws DaoSaveException 
 * 
 */

		public void save(Identity identity) throws DaoSaveException;
		public void delete(Identity identity)throws DaoDeleteException;
		public void update(Identity identity) throws DaoUpdateException;
		public List<Identity> search(Identity criteria) throws DaoSearchException;
			
		

}

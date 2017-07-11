package fr.epita.iamcore.launcher;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

import fr.epita.iam.Exception.DaoDeleteException;
import fr.epita.iam.Exception.DaoSaveException;
import fr.epita.iam.Exception.DaoUpdateException;
import fr.epita.iam.services.Authentication;
import fr.epita.iam.services.CommonDAO;
import fr.epita.iam.services.JDBCIdentityDAO;
import fr.epita.iamcore.datamodel.Identity;
import fr.epita.logging.LogConfig;
import fr.epita.logging.Logger;

/**
 * 
 * @author Ejuma
 *
 */
/**
 * 
 * This is the main class of the program
 * it includes calls to the logger to track errors. 
 * it also uses authentication from the authentication class to check if user is authenticated
 * (has entered a valid login and password)
 * 
 * The user chooses an operation to carry out in this class. 
 * the operations include to create to update/modify, to delete or to exit. .
 *
 */
public class Launcher{

	public static void main(String[] args) throws FileNotFoundException, SQLException {
		CommonDAO dao = new JDBCIdentityDAO();
		
		LogConfig conf = new LogConfig("/temp/application.log");
		Logger logger = new Logger(conf);
		
		logger.log("beginning of the program");
		Scanner scanner = new Scanner(System.in); //takes adm input from the user
		
		System.out.println("User name :");
		String userName = scanner.nextLine();
		System.out.println("Password :");
		String password = scanner.nextLine();
		
			//the authenticator service is used to check everything regarding the authentication of the user	
		if (!Authentication.authenticate(userName, password)) {
			logger.log("unable to authenticate "  + userName);// this runs if the user provides an entry not authenticated
			scanner.close();
			return;
		} else {
			// When the authentication provided is correct, the user proceeds through the following
			String answer = "";
			while (!"4".equals(answer)) {
				System.out.println("Successfully authenticated");
				System.out.println("1. Create Identity");
				System.out.println("2. Update Identity");
				System.out.println("3. Delete Identity");
				System.out.println("4. Quit");
				System.out.println("your choice : ");
				
				logger.log("User chose the " + answer + " choice");//this is used to track any errors in the user choice

				answer = scanner.nextLine();

				switch (answer) {
				
				case "1":
					System.out.println("Create Identity");
					logger.log("selected create identity");//in the event that there is an error in creating the identity
					
					// Create Identity. User inputs user name, in this case, called display name
					
					System.out.println("please input the identity display name :");
					String displayName  = scanner.nextLine();
					System.out.println("identity email :");
					String email = scanner.nextLine();
					Identity identity = new Identity(displayName, null, email);
					try {
						dao.save(identity);
						System.out.println("the save operation completed successfully");
					} catch (DaoSaveException e) {
						//this line is executed if the save operation was not successful
						System.out.println("Save operation could not be completed please see details :" + e.getMessage());
					}
					break;
					
				case "2":

					// Update Identity
					System.out.println("Update Identity");

					logger.log("selected update identity");//in the event that there is an error in creating the identity
					
					// Create Identity. User inputs user name, in this case, called display name
					
					System.out.println("please input the uid:");
					String uid  = scanner.nextLine();

					System.out.println("identity new name :");
					String Name = scanner.nextLine();
					System.out.println("identity new email :");
					String Email = scanner.nextLine();
					Identity Identity = new Identity(Name, uid, Email);
					try {
						dao.update(Identity);
						System.out.println("the save operation completed successfully");
					} catch (DaoUpdateException e) {
						//this line is executed if the save operation was not successful
						System.out.println("Save operation could not be completed please see details :" + e.getMessage());
					}
					break;
					
				case "3":

					// Delete Identity
					System.out.println("Delete Identity");

					System.out.println("Enter Uid :");
					String Uid2  = scanner.nextLine();
					
					Identity identity2 = new Identity(null, Uid2, null);
					try {
						dao.delete(identity2);
						System.out.println("the save operation completed successfully");
					} catch (DaoDeleteException e) {
						//this line is executed if the save operation was not successful
						System.out.println("Save operation could not be completed please see details :" + e.getMessage());
					}
					break;

					
				case "4":

					System.out.println("you decided to quit, bye!");
					System.exit(1);
					scanner.close();
					break;
				default:

					System.out.println("unrecognized option : type 1,2,3 or 4 to quit");
					break;
				}

			}

		}

	}
}

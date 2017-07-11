package fr.epita.iam.services;

public class Authentication {

	/**
	 * This method is checking authentication
	 * @param userName this is the user name to grant access into the program
	 * @param password is the password to grant access to the program. 
	 * Authentication checks through user name and password. 
	 * For this program, user name is adm and password is pwd
	 * @return this returns the user name and password
	 */
	public static boolean authenticate(String userName, String password){
		
		return "adm".equals(userName) && "pwd".equals(password);
		
	}
}

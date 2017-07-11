package fr.epita.iam.services;

public class Authentication {

	/**
	 * This method is checking authentication
	 * @param userName
	 * @param password
	 * @return
	 */
	public static boolean authenticate(String userName, String password){
		
		return "adm".equals(userName) && "pwd".equals(password);
		
	}
}

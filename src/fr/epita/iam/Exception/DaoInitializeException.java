package fr.epita.iam.Exception;
/**
 * 
 * @author Ejuma
 * This exception is executed when the initialization is not successful
 *
 */

public class DaoInitializeException  extends Exception{
	private String displayname ;
	private String email;
	
	public void  DaoInitializeException(String displayname, String email) {
		this.displayname = displayname;
		this.email = email;
	
	}
		public String getMessage() {
			
			return super.getMessage() + String.valueOf(this.displayname) + String.valueOf(this.displayname) ;
	}

}

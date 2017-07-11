package fr.epita.iam.Exception;

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

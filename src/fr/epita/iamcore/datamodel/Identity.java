package fr.epita.iamcore.datamodel;

/**
 * 
 * @author Ejuma
 */

public class Identity {
	private String displayname;
	private String uid;
	private String email;
	
	
	
	public Identity(String displayname, String uid, String email) {
		this.displayname = displayname;
		this.uid = uid;
		this.email = email;
	}

	/**
	 *@param displayname String displayname is the name of the user
	 *@param uid String uid of the user
	 *@param email String email of the user
	 *
	 *
	 */
/**
 * @param displayname the name of the user
 * @return the display name 
 */
	
	public String getDisplayname() {
		return displayname;
	}
	
	public void setDisplayname(String displayname) {
		this.displayname = displayname;
	}
	/**
	 * @param uid is the id of the user, automatically generated from the database
	 * @return uid  
	 */
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
		/**
		 * @param email is the user email
		 * @return email  
		 */
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Identity [displayName=" + displayname + ", uid=" + uid + ", email=" + email + "]";
	}
	

}

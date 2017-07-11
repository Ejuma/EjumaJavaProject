package fr.epita.iamcore.datamodel;

/**
 * 
 * @author Ejuma
 *
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
	 *@param displayname
	 *@param uid
	 *@param email
	 *
	 */
	
	public String getDisplayname() {
		return displayname;
	}
	
	public void setDisplayname(String displayname) {
		this.displayname = displayname;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
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

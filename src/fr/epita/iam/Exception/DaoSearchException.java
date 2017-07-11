package fr.epita.iam.Exception;
/**
 * 
 * @author Ejuma
 * This exception is executed when the search operation is not successful
 * 
 *
 */

public class DaoSearchException  extends Exception{
	
private Object criteria;
	
	public void setcriteria (Object cta) {
		this.criteria = cta;
	}
	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	
	public String getMessage() {
		
		return super.getMessage() + String.valueOf(this.criteria);
	}


}

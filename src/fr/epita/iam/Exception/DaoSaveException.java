
package fr.epita.iam.Exception;

/**
 * 
 * @author Ejuma
 * This is executed when the save operation is not successful
 *
 */

public class DaoSaveException extends Exception {
	private Object ErrorObject;
	
	public void setErrorObject (Object err) {
		this.ErrorObject = err;
	}
	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	
	public String getMessage() {
		
		return super.getMessage() + String.valueOf(this.ErrorObject);
	}


}

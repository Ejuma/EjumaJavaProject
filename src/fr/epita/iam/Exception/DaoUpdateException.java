package fr.epita.iam.Exception;
/**
 * 
 * @author Ejuma
 *This exception is executed when the update operation is not successful
 */

public class DaoUpdateException extends Exception{
private Object faultObject;
	
	public void setFaultObject(Object obj){
		this.faultObject = obj;
	}

	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage() {
		return super.getMessage() + String.valueOf(this.faultObject);
	}
}

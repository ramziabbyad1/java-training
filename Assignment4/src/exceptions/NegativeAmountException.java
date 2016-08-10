package exceptions;

public class NegativeAmountException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String msg;
	public NegativeAmountException(){
		msg = "Can not use a negative amount.  Please enter a valid positive number.";
	}
	@Override
	public String toString(){
		return msg;
	}

}

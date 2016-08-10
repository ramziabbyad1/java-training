package exceptions;

public class BalanceNotEnoughException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String msg = null;
	public BalanceNotEnoughException(double balance, double amt){
		double off = amt - balance;
		msg = "Balance not enough. Current balance is $" + balance + ".  You are short by $" + off + "." ;
	}
	@Override
	public String toString(){
		return msg;
	}
	
}

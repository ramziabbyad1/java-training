

public class MaxBooksException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String msg = null;
	public MaxBooksException(String name){
		msg = "Book borrowing limit reached for " + name;
	}
	
	@Override
	public String toString(){
		return msg;
	}

}

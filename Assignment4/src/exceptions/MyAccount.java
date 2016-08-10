package exceptions;

public class MyAccount{
    private double balance;
    public static void main (String [] args){
     MyAccount ac = new MyAccount();
     try{
	     ac.deposit(100);
	     System.out.println("Balance:-" + ac.balance);
	     ac.deposit(-10);
	     System.out.println("Balance:-" + ac.balance);
	     ac.deposit(50);
	     System.out.println("Balance:-" + ac.balance);
	     ac.withdraw(200);
	     System.out.println("Balance:-" + ac.balance);
     } catch(BalanceNotEnoughException e){
    	 e.printStackTrace();
     } catch(NegativeAmountException e){
    	 e.printStackTrace();
     }
     }
     public void deposit(double amt) throws NegativeAmountException{
    	 if(amt > 0){
           balance+=amt;
    	 }
    	 else{
    		 throw new NegativeAmountException();
    	 }
     }
     public void withdraw(double amt) throws BalanceNotEnoughException, NegativeAmountException{
    	 if(balance - amt < 0 && amt > 0){
    		 throw new BalanceNotEnoughException(balance, amt);
    	 }
    	 else if(amt < 0){
    		 throw new NegativeAmountException();
    	 }
    	 else{
           balance-=amt;
    	 }
    	 
     }
}

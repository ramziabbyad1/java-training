package garages;

public class Harness {

	public static void main(String[] args) {
		Ticket carTicket = new CarTicket();
		Ticket truckTicket = new TruckTicket();
		carTicket.setOutstanding(true);
	}

}

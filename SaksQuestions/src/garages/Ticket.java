package garages;

import java.sql.Timestamp;

public abstract class Ticket {
	public enum Day {SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
	    THURSDAY, FRIDAY, SATURDAY}
	private long id;
	private Timestamp timeIssued;
	private Timestamp timePaid;
	private boolean isOutstanding;
	private Day dayOfWeek;
	private Rate rate;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Timestamp getTimeIssued() {
		return timeIssued;
	}
	public void setTimeIssued(Timestamp timeIssued) {
		this.timeIssued = timeIssued;
	}
	public Timestamp getTimePaid() {
		return timePaid;
	}
	public void setTimePaid(Timestamp timePaid) {
		this.timePaid = timePaid;
	}
	public boolean isOutstanding() {
		return isOutstanding;
	}
	public void setOutstanding(boolean isOutstanding) {
		this.isOutstanding = isOutstanding;
	}
	public Day getDayOfWeek() {
		return dayOfWeek;
	}
	public void setDayOfWeek(Day dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
	public Rate getRate() {
		return rate;
	}
	public void setRate(Rate rate) {
		this.rate = rate;
	}
	
	
}

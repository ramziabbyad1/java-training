package problem2;

class DVD extends MediaItem{
	private String rating;
	private String lengthOfBonus;
	public DVD(String title, boolean present, int copyYear, String runtime, String rating, String lengthOfBonus){
		super(title, present, copyYear, runtime);
		this.rating = rating;
		this.lengthOfBonus = lengthOfBonus;
	}
	
	@Override
	public String toString() {
		return "DVD [title=" + getTitle() + ", present=" + isPresent()
				+ ", copyYear=" + getCopyYear()+ ", total runtime="+getTime() +", rating=" + rating + ", lengthOfBonus=" + lengthOfBonus
				+ "]";
	}

	final public String getRating(){
		return rating;
	}
	final public String getLengthOfBonus(){
		return lengthOfBonus;
	}
	@Override
	public String getTime(){
		return addTime(super.getTime(), lengthOfBonus);
	}
	private String addTime(String time1, String time2){

		int time = 0;
		String[] arrTime1 = time1.split("min");
		String[] arrTime2 = time2.split("min");

		time += Integer.parseInt(arrTime1[0]);
		time += Integer.parseInt(arrTime2[0]);

		return time +"min";
				
		
	}
}

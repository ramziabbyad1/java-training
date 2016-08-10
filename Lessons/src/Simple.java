
public class Simple {
	private String str;
	private int number;
	public Simple(String str, int number){
		this.str = str;
		this.number = number;
	}
	@Override
	public String toString() {
		return "Simple [str=" + str + ", number=" + number + "]";
	}
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
}

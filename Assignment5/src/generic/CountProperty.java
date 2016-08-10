package generic;

import java.util.List;

public class CountProperty<T extends Integer> {
	private int count;
	CountProperty(List<T> list){
		this.count = countPrimes(list);
	}
	int countPrimes(List<T> list){
		int count = 0;
		for(T t:list){
			if(t == 1){
				count++;
			}
			for(int i = 2; i <= Math.sqrt((double)t); i++){
				if((t/i)*i == t){
					int ting = t/i;
					System.out.println("T: " +t);
					System.out.println("I: " +i);
					System.out.println("t/i: " +ting);
					count++;
					break;
				}
			}
		}
		return list.size()-count;
	}
	public int getCount() {
		return count;
	}

}

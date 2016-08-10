package map;

import java.util.Comparator;

public class ValueComparator implements Comparator<Double> {


	@Override
	public int compare(Double o1, Double o2) {
		if(o1.doubleValue()== o2.doubleValue()){
			return 0;
		}
		else{
			return (int) (o2.doubleValue() - o1.doubleValue());
		}
	}

	
}

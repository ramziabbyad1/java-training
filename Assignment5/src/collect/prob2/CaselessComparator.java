package collect.prob2;

import java.util.Comparator;

public class CaselessComparator implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {
		if(s1.toLowerCase().equals(s2.toLowerCase())){
			return 0;
		}
		else{
			return s1.toLowerCase().compareTo(s2.toLowerCase());
		}
	}

}

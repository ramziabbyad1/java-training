package collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;

public class ComparatorDemo {
	
	static class StringComparator implements Comparator<String> {

		@Override
		public int compare(String o1, String o2) {
			return o1.compareToIgnoreCase(o2);
		}
		
	}
	
	static class Int implements Comparable<Double> {
		Double val;
		Int(Double i){
			this.val = i;
		}
		@Override
		public int compareTo(Double o) {
			return (int)Math.signum(Math.sin(this.val - o));
		}

		
	}

	public static void main(String[] args) {
		Comparator<String> comparator = new StringComparator();
		Set<String> set = new LinkedHashSet<>();
		set.add("peePee");
		set.add("mepee");
		set.add("Creepee");
		set.add("creePe");
		String[] toSort = set.toArray(new String[0]);
		Arrays.sort(toSort, comparator);
		System.out.println(Arrays.asList(toSort));
		Arrays.sort(toSort);
		System.out.println(Arrays.asList(toSort));

		
	}

}

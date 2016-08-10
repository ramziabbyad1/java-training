package generic;

import java.util.ArrayList;
import java.util.List;

public class GenericApp {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		list.add(10);
		list.add(11);
		list.add(12);
		list.add(13);
		list.add(14);
		list.add(15);
		list.add(16);
		list.add(17);
		list.add(19);
		CountProperty<Integer> cp = new CountProperty<>(list);
		System.out.println("PrimeCount: " +cp.getCount());
		
		Integer[] arr = {0,1,2, 3, 4, 5};
		Swap<Integer> swp = new Swap<>();
		swp.setArr(arr);
		swp.swap(arr, 0, 3);
		System.out.println("Swapped Array");
		for(int i: arr){
			System.out.println(i);
		}
		Integer[] arr2 = list.toArray(new Integer[list.size()]);
		Max<Integer> m = new Max<>(arr2, -1, 0);
		System.out.println("Max in range: " + m.getMax());
		

	}
	
	public static void print(List<? extends Number> list) {
	    for (Number n : list)
	        System.out.print(n + " ");
	    System.out.println();
	}

}

package map;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MapDemo {

	public static void main(String[] args) {
		LinkedHashMap<Double, String> lhm = new LinkedHashMap<>();
		for(double i = 10; i >= 0; i-=.1){
			lhm.put(i,""+i*i);
		}
		
		Set<Double> keySet = lhm.keySet();
/*		Collection<String> valueSet = lhm.values();
		int len = keySet.size();
		Iterator<String> itr = valueSet.iterator();*/
		for(Double key:keySet){
			System.out.println("Key: " + key);
			System.out.println("Value: " + lhm.get(key));
		}
		
		//Note the effects of numerical inaccuracy....almost none of the elements are retrievable
		System.out.println("Key: " + ".1 " + "Value: " + lhm.get(.1));
		System.out.println("Key: " + "2 " + "Value: " + lhm.get(2.0));
		System.out.println("Key: " + "10 " + "Value: " + lhm.get(10.0));
		
		//So clean out the structure
		lhm.clear();
		
		//using a more numerically stable process gets rid of the error completely
		
		for(double i = 0; i <= 100.0; i+=1){
			lhm.put(i/10, ""+ i*i/100);
		}
		
		keySet = lhm.keySet();

		for(Double key:keySet){
			System.out.println("Key: " + key);
			System.out.println("Value: " + lhm.get(key));
		}

		//Now they are all retrievable!
		System.out.println("Key: " + ".1 " + "Value: " + lhm.get(.1));
		System.out.println("Key: " + "2 " + "Value: " + lhm.get(2.0));
		System.out.println("Key: " + "10 " + "Value: " + lhm.get(10.0));
	
		//Tree map example
		Map<Double, Double> tm = new TreeMap<>();
		System.out.println("--------Before Insertion---------");
		for(int i =0; i <= 100; i++){
			double key = Math.pow(-1, Math.round(Math.random()+1))*Math.random();
			double value = Math.pow(-1,Math.round(Math.random()+1) )*Math.random();
			tm.put(key, value);
			System.out.println("Key: " + key);
			System.out.println("Value: " + value);
		}
		
		System.out.println("-------After Insertion--------");
		keySet = tm.keySet();
		for(double key:keySet){
			System.out.println("Key: " + key);
			System.out.println("Value: " + tm.get(key));
		}
		
		//Now let's sort it on value instead of key
		Map<Double, Double> tm2 = new TreeMap<>(new ValueComparator());
		tm2.putAll(tm);
		System.out.println("size of old: "+ tm.size());
		System.out.println("size of new: "+ tm2.size());
		System.out.println("-------Sorted on descending Value--------");
		keySet = tm2.keySet();
		for(double key:keySet){
			System.out.println("Key: " + key);
			System.out.println("Value: " + tm2.get(key));
		}

	}

}

package datastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang3.ArrayUtils;

public class WhichCity {
	
	static String[] CITY = {"NY","LA","MIAMI","CH"};
	
	static void loadMap(Map<String, Double> map, double[][] income) {
		for(int i = 0; i < CITY.length; i++){
			map.put(CITY[i], income[i][0]);
		}
	}

	public static void main(String[] args) throws Exception{
		double[][] cityPrices = {
				{10, 8, 12},
				{11, 8.50, 11.55},
				{8.75, 6.90, 10},
				{10.50, 8.25, 11.75}
		};
		double[][] quantities = {{1250},{400},{250}};
		double[][] income = MatrixMultDemo.mult(cityPrices, quantities);
		System.out.println("income by city");
		System.out.println(MatrixMultDemo.matrixString(income));
		Map<String, Double> incomeByCity = new HashMap<>();
		loadMap(incomeByCity, income);
		Set<Entry<String, Double>> entries = incomeByCity.entrySet();
		List<Entry<String, Double>> list = new ArrayList<>();
		list.addAll(entries);
		list.sort(new Comparator<Entry<String, Double>> (){

			@Override
			public int compare(Entry<String, Double> o1,
					Entry<String, Double> o2) {
				return (-1)*o1.getValue().compareTo(o2.getValue());
			}
			
		});
		System.out.println("Sorted by City");
		System.out.println(list);
		list.forEach(x -> System.out.println(x));
	}

}

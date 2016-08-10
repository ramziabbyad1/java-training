package easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	//maps list values to indices
	private static Map<Integer,Integer> cache = new HashMap<>();
	
	private static Map<Integer,Integer> loadCache(int[] list) {
		Map<Integer,Integer> cache = new HashMap<>();
		for(int i = 0; i < list.length; i++) {
			cache.put(list[i], i);
		}
		return cache;
	}
	final public static int LENGTH = 2;
    public static int[] findTwoSum(int[] list, int sum) {
    	int[] indices = new int[LENGTH];
    	Map<Integer, Integer> cache = loadCache(list);
    	boolean foundSum = false;
    	for(int i = 0; i < list.length; i++) {
    		int otherEl = sum - list[i];
    		if (cache.containsKey(otherEl) && otherEl != list[i]){
    			indices[0] = cache.get(otherEl);
    			indices[1] = i;
    			foundSum = true;
    			break;
    		}
    	}
    	if(foundSum) return indices;
        return null;
    }

    public static void main(String[] args) {
        int[] indices = findTwoSum(new int[] { 1, 3, 5, 7, 9 }, 12);
        System.out.println(indices[0] + " " + indices[1]);
    }

}

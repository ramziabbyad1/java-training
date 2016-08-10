package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


public class AreAnagrams {
	//static Set<Character> set = new HashSet<>();
	public static Map<Character, Integer> getSet(char[] a) {
		Map<Character, Integer> set = new HashMap<>();
		for(char c: a) {
			if(set.containsKey(c)){
				set.put(c, set.get(c)+1);
			} else {
				set.put(c, 1);
			}
		}
		return set;
	}
    public static boolean areAnagrams(String a, String b) {
    	Map<Character, Integer> aSet = getSet(a.toCharArray());
    	Map<Character, Integer> bSet = getSet(b.toCharArray());
    	//boolean areAnagrams = true;
    	if(aSet.size() != bSet.size()) return false;
    	for(char key: aSet.keySet()) {
    		if(bSet.get(key) != aSet.get(key)) {
    			return false;
    		}
    	}
    	return true;
    }

    public static void main(String[] args) {
        System.out.println(areAnagrams("momdad", "dadmom"));
    }
}

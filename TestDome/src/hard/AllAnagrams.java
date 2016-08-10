package hard;

import java.util.Collection;
import java.util.HashSet;

public class AllAnagrams {
    public static Collection<String> getAllAnagrams(String string) {
        Collection<String> set = new HashSet<>();
    	if(string.matches(string.charAt(0)+"*")) {
    		set.add(string);
    	}else {
    		getAllAnagrams(set, "", string, string.length());
    	}
        return set;
    }
    //static Collection<String> set = new HashSet<>();
    public static void getAllAnagrams(Collection<String> set, String acc, String string, int n) {
    	//System.out.println(n);
    	if(acc.length() == n) {
    		set.add(acc);
    	}
    	else {
	    	for(int i = 0; i < string.length(); i++) {
	    		getAllAnagrams(set, acc+string.charAt(i), string.substring(0, i)+string.substring(i+1), n);
	    	}
    	}
    }

    public static void main(String[] args) {
        Collection<String> anagrams = getAllAnagrams("aaaa");
        for (String a : anagrams)
            System.out.println(a);
    }
}

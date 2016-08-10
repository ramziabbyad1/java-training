package collect.prob2;

import java.util.*;

public class FindDups {
    public static void main(String[] args) {
        SortedSet<String> s = new TreeSet<String>(new CaselessComparator());
        for (String a : args)
            if (!s.add(a))
                System.out.println("Duplicate detected: " + a);
 
        System.out.println(s.size() + " distinct words: " + s);
        
        List<String> list = new ArrayList<>();
        list.add("      hello     ");
        list.add("  there.");
        list.add("Got   ");
        list.add("   rid  ");
        list.add("of");
        list.add("some extra space.       ");
        trim(list);
        
        System.out.println("Trimmed list: " + list);
    }
    
    static void trim(List<String> list){
    	int i =0;
    	for(String s:list){
    		list.set(i, s.trim());
    		i++;
    	}
    }
}

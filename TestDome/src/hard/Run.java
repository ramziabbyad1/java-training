package hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Run {
	
	 

    public static int indexOfLongestRun(String str) {
    	if(str.length() == 0) return -1;
    	int index = 0;
    	int maxLen = 1;
    	int maxIndex = 0;
    	while(index < str.length()-1) {
    		int nextIndex = index +1;
    		char curr = str.charAt(index);
    		char next = str.charAt(nextIndex);
    		int streamLen = 1;
    		while(curr == next) {
    			streamLen++;
    			nextIndex++;
    			if(nextIndex < str.length()) { 
    				next = str.charAt(nextIndex);
    			} else {
    				next = ' ';
    			}
    		}
    		if(streamLen > maxLen) {
    			maxIndex = index;
    			maxLen = streamLen;
    		}
    		System.out.println("curr = " + curr);
    		System.out.println("next = " + next);
    		System.out.println("index = "+ index);
    		System.out.println("nextIndex = "+ nextIndex);
    		System.out.println("streamLen = "+streamLen);
    		System.out.println("maxLen = " + maxLen);
    		System.out.println("maxIndex = " + maxIndex);
    		curr = next;
    		index = nextIndex;
    	}
    	
    	return maxIndex;
    }

    public static void main(String[] args) {
    	String str = "abbcccddddddddcccbbbbbaaaaaa";
    	System.out.println(str.length());
        System.out.println(indexOfLongestRun(str));
        /*for(char c: map.keySet()) {
        	System.out.println(c);
        	System.out.println(Arrays.toString(map.get(c)));
        }
        System.out.println(map);*/
    }

}

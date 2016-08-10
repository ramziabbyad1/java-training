package easy;


import java.util.HashSet;
import java.util.Set;

public class MissingNum {
	
	static int missingNum1(int n, int[] in) {
		Set<Integer> set = new HashSet<>();
		for(int x: in){set.add(x);}
		for(int i=1; i <= n; i++) {
			if(!set.contains(i)) return i;
		}
		
		return 0;
	}
	static int missingNumBigInt(int n, int[] in) {
		int bitset1 = in[0];
		int bitset2 = 1;
		for(int i=1; i < n; i++) {
			bitset1 ^= i;
			bitset2 ^= (i+1);
		}
		bitset2 ^= n+1;
		return bitset1^bitset2;
	}

	public static void main (String[] args) {
	    int[] in = {1,3,4,6,5};
	    int sum = (in.length+1)*(in.length+2)/2;
	    
		for(int i = 0; i < in.length; i++) {
		    sum -= in[i];
		} 
		
		System.out.println(sum);
		
		System.out.println(missingNum1(in.length, in));
		System.out.println(missingNumBigInt(in.length, in));
	}
}



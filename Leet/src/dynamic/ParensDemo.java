package dynamic;

import java.util.HashSet;
import java.util.Set;

public class ParensDemo {
	
	public static Set<String> validParens(int n) {
		Set<String> set = new HashSet<>();
		if (n == 0) {
			set.add("");
		} else {
			Set<String> prev = validParens(n-1);
			for(String str: prev) {
				for(int i = 0; i < str.length(); i++){
					if(str.charAt(i) == '(') {
						String ins = insertParenAt(str, i);
						set.add(ins);
					}
				}
				set.add("()"+str);
			}
			
		}
		return set;
	}
	
	private static String insertParenAt(String str, int i) {
		String left = str.substring(0, i+1);
		String right = str.substring(i+1);
		return left+"()"+right;
	}


	public static void main(String[] args) {

		System.out.println(validParens(1));
		System.out.println(validParens(2));
		System.out.println(validParens(3));
	}

}

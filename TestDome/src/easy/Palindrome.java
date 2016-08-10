package easy;

public class Palindrome {
    public static boolean isPalindrome(String str) {
    	str = str.toLowerCase();
    	System.out.println(str);
    	str=str.replaceAll("\\W", "");
        for(int i = 0, k = str.length()-1; i < str.length() && k >= 0; i++, k--){
/*        	if(str.charAt(i) == '.' || str.charAt(i) == ' ') {
        		i++;
        	}
        	if(str.charAt(k) == '.' || str.charAt(k) == ' ') {
        		k--;
        	}*/
        	System.out.println("str[i] = "+str.charAt(i));
        	System.out.println("str[k] = "+str.charAt(k));
        	System.out.println("i = "+i);
        	System.out.println("k = "+k);
        	if(i <str.length() && k >= 0 && str.charAt(i) != str.charAt(k)) {
        		return false;
        	}
        	
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("Noel sees Leon."));
    }
}

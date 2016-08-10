import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegexDemo {

	public static void main(String[] args) {
		boolean found;
		boolean matches;
		Pattern pat;
		Matcher mat;
		pat = Pattern.compile("Java");
		mat = pat.matcher("Java Sucks.  I hate java.  Java is for losers.");
		//matches exactly matches the patter whereas find finds the first instance
		matches = mat.matches();
		System.out.println("Matches? " + matches);
		found = mat.find();
		System.out.println("Found? " + found);
		pat = Pattern.compile("\\d{3}-\\d{2}-\\d{4}");
		mat = pat.matcher("754-20-0718");
		
		while(mat.find()){
			System.out.println("Found? " + mat.matches());
		}
		
		

	}

}

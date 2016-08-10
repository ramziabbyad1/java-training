package generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenericsDemo {
	
	static <E> void printListGen(List<E> lst) {
		lst.forEach(x -> System.out.println(x));
	}
	
	static void printListWild(List<?> lst) {
		lst.forEach(x -> System.out.println(x));
	}
	
	static <E extends Number> double addNums(E first, E second) {
		return first.doubleValue()+second.doubleValue();
	}
	
	interface Sink<T> {
		void flush(T t);
	}
	
	static class Collections {
		 public static <T> Set<T> unmodifiableSet(Set<? extends T> set) {
			return java.util.Collections.unmodifiableSet(set);
		}
	}
	
	static <T> T writeAll(Collection<T> coll, Sink<? super T> snk) {
		T last = null;
		for(T t: coll){
			snk.flush(t);
			last = t;
		}
		return last;
	}
	
/*	static double addNums(List<? extends Number> lst){
		double out=	lst
				.stream()
				.reduce(0, (n1,n2) -> new Number(n1.doubleValue()+n2.doubleValue()))
				.get();
		return 0;
				
	}*/

	public static void main(String[] args) {
		Collection<String> coll = new ArrayList<>();
		Sink<Object> snk = null;
		String str =writeAll(coll, snk);
		Set<?> unknownSet = new HashSet<String>();
		//unknownSet.add("abc");
		Set<? super String> set1 = Collections.unmodifiableSet(unknownSet);
		Set<?> set2 = Collections.unmodifiableSet(unknownSet);
		List<String> list = new ArrayList<>();
		//List<Object> ol = list; //illegal!
		List<Object> ol = new ArrayList<>();
		//list = ol; //illegal!
		
	}

}

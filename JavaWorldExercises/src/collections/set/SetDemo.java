package collections.set;

import java.util.LinkedHashSet;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import collections.Book;

public class SetDemo {

	public static void main(String[] args) {
		Book b1 = new Book(0, "Books!");
		Book b2 = new Book(1, "Books1!");
		Book b3 = new Book(2, "Books2!");
		Book b4 = new Book(3, "Books3!");
		
		Set<Book> books = new LinkedHashSet<>();
		books.add(b4);
		books.add(b3);
		books.add(b2);
		books.add(b1);
		
		System.out.println(books);
		
		NavigableSet<Book> booksSorted = new TreeSet<>();
		booksSorted.addAll(books);
		//booksSorted.add(null); //illegal
		System.out.println(booksSorted);
		System.out.println("Floor of id = 4 => "+booksSorted.floor(new Book(4,"")));
	}

}

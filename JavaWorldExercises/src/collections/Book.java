package collections;

public class Book implements Comparable<Book>{
	int id;
	String title;
	public Book(int id, String title) {
		this.id = id;
		this.title = title;
	}
	
	@Override
	public boolean equals(Object b) {
		return b instanceof Book ? false : this.id == ((Book) b).id;
	}
	
	@Override
	public int hashCode() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + "]";
	}

	@Override
	public int compareTo(Book o) {
		return Integer.compare(this.id, o.id);
	}
	
	
	
}

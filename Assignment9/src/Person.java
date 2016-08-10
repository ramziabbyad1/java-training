

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Person {
	private int idPerson;
	private String name;
	private int maxBooks;
	//private int numBooks;
	private ArrayList<Book> books;
	
	public ArrayList<Book> getBooks() {
		return books;
	}
	public void setBooks(ArrayList<Book> books) {
		this.books = books;
	}
	public Person(){
		this.name = "Unknown";
		this.maxBooks = 3;
		books = new ArrayList<>();
	}
	public Person(String name){
		this.name = name;
		this.maxBooks = 3;
		books = new ArrayList<>();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMaxBooks() {
		return maxBooks;
	}
	public void setMaxBooks(int maxBooks) {
		this.maxBooks = maxBooks;
	}
	public void checkInBook(Book b1){
		books.remove(b1);
	}
	public void checkOutBook(Book b2){
		books.add(b2);
	}

	@Override
	public String toString() {
		return name + " ("+maxBooks+" Books)";
	}
	public int getIdPerson() {
		return idPerson;
	}
	public void setIdPerson(int idPerson) {
		this.idPerson = idPerson;
	}
	public int getNumBooks(Connection conn) throws SQLException {
		String preparedStatement = "select count(*) from libdata.books where idPerson = ?";
		PreparedStatement ps = conn.prepareStatement(preparedStatement);
		ps.setInt(1, getIdPerson());
		ResultSet rs = ps.executeQuery();
		rs.next();
		int numBooks = rs.getInt(1);
		return numBooks;
	}
	/*public void setNumBooks(Connection conn) {
		this.numBooks = numBooks;
	}*/
	
	
}

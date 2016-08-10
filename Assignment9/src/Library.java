

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Library {

	
	public String name;
	private int total_books = 0;
	private int counter = 0;
	private static Connection conn = null;
	public ArrayList<Book> books;
	public ArrayList<Person> persons;

	public Library(String name) {
		this.name = name;
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/";
		String dbname = "source_mantra_db";
		String username = "root";
		String password = "ClaraPark728!";
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url + dbname,username,password);
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//books = new ArrayList<>();
		//persons = new ArrayList<>();
		
	}

	public ArrayList<Book> getBooks() {
		return books;
	}

	public void addBook(Book b1) {
		try {
			PreparedStatement ps = conn.prepareStatement("insert into libdata.books (title, author) values(?,?);");
			ps.setString(1, b1.getTitle());
			ps.setString(2, b1.getAuthor());
			int i = ps.executeUpdate();
			if(i==1){
				System.out.println("Query OK. 1 row added.");
			}
			ps = conn.prepareStatement("select max(idBook) from libdata.books;");
			ResultSet rs = ps.executeQuery();
			
			//System.out.println("Result set size: " + );
			rs.next();
			int idBook = rs.getInt(1);
			System.out.println(idBook);
			b1.setIdBook(idBook);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//counter++;
		//total_books++;
		//books.add(b1);
		
	}

	public void removePerson(Person p1) {
		//persons.remove(p1);
		
	}

	public void addPerson(Person p1) {
		//persons.add(p1);
		try {
			PreparedStatement ps = conn.prepareStatement("insert into libdata.persons (name,maxBooks) values (?,?);");
			ps.setString(1, p1.getName());
			ps.setInt(2, p1.getMaxBooks());
			int i = ps.executeUpdate();
			if(i==1){
				System.out.println("Query OK. 1 row added.");
			}
			ps = conn.prepareStatement("select max(idPerson) from libdata.persons;");
			ResultSet rs = ps.executeQuery();
			rs.next();
			int idPerson = rs.getInt(1);
			p1.setIdPerson(idPerson);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public ArrayList<Person> getPeople() {
		return persons;
	}

	public void removeBook(Book b1) {
		//total_books--;
		//books.remove(b1);
		
	}

	public boolean checkoutBook(Book b1, Person p1) throws MaxBooksException, CheckOutException, SQLException {
		String preparedStatement = "update libdata.books set idPerson=? WHERE idBook=?";
		PreparedStatement ps = conn.prepareStatement(preparedStatement);
		ps.setInt(1, p1.getIdPerson());
		ps.setInt(2, b1.getIdBook());
		
		if(p1.getNumBooks(conn)<p1.getMaxBooks() && !b1.isCheckedOut()){
			b1.setPerson(p1);
			
			int k = ps.executeUpdate();
			if(k == 1){
				System.out.println("Query ok. 1 row updated.");
			}
			//counter--;
			return true;
		}else{
			if(p1.getNumBooks(conn)>=p1.getMaxBooks()){
				throw new MaxBooksException(p1.getName());
			}
			if(b1.isCheckedOut()){
				throw new CheckOutException(b1.getTitle());
			}
			return false;
		}
	}

	public boolean checkinBook(Book b1) {
		String preparedStatement = "update libdata.books set idPerson = NULL where idBook=?";
		try {
			PreparedStatement ps = conn.prepareStatement(preparedStatement);
			ps.setInt(1, b1.getIdBook());
			int k = ps.executeUpdate();
			if(k==1){
				System.out.println("Query OK. 1 row updated.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(b1.isCheckedOut()){
			b1.setCheckedOut(false);
			counter++;
			return true;
		}else{
			System.out.println(b1+" hasn't been checkedout yet! Can't return.");
			return false;
		}
	}
	
	private void status() throws SQLException{
		/*
		 * Name:-
		 * No of Books:-5 books
		 * No of Persons- 5 persons
		 * Available Books:-3
		 */
		Statement s = conn.createStatement();
		ResultSet rs = s.executeQuery("select count(idBook) from libdata.books;");
		rs.next();
		int bookSize = rs.getInt(1);
		System.out.println("Total number of books : " +bookSize);
		rs = s.executeQuery("select count(*) from libdata.books where idPerson != NULL;");
		rs.next();
		int booksAvail = rs.getInt(1);
		System.out.println("No of books available: " + booksAvail);
		rs = s.executeQuery("select count(idPerson) from libdata.persons;");
		rs.next();
		System.out.println("No of library members : " + rs.getInt(1));
		rs = s.executeQuery("select title,author,persons.name from libdata.books "
				+ "join libdata.persons on libdata.books.idPerson = libdata.persons.idPerson;");
		System.out.println("------Summarry of all books---------");
		while(rs.next()){
			System.out.println("title : "+rs.getString(1) +" author : " + rs.getString(2) + " name : " + rs.getString(3));
		}
		rs = s.executeQuery("select * from libdata.persons");
		System.out.println("------Summary of all people-----");
		while(rs.next()){
			System.out.println("personID : " + rs.getInt(1) + " name : " + rs.getString(2) + " max books : " + rs.getInt(3));
		}
		
	}
	@Override
	public String toString() {
		return "Library [name=" + name + ", books=" + books + ", persons="
				+ persons + "]";
	}
	
	public void init(){
		
	}

	public static void main(String[] args){
		/*
		 * create lib
		 * create Persons and Books
		 * display the status of lib
		 * checkout books
		 * display the status
		 * checkout books
		 * checkin book
		 * display the status
		 */
		//System.out.println("DO");
		
		//Connection conn = this.conn;
		Library library = new Library("Comic books library");
		
		Book b1 = new Book("The Fantastic Four");
		b1.setAuthor("Billy Bob");
		Book b2 = new Book("X-Men");
		b2.setAuthor("Billy Bo");
		Book b3 = new Book("Aliens");
		b3.setAuthor("Jimbo James");
		Book b4 = new Book("Predator");
		b4.setAuthor("Santa Sally");
		library.addBook(b1);
		library.addBook(b2);
		library.addBook(b3);
		library.addBook(b4);
		
		Person p1 = new Person("Ramzi Abbyad");
		Person p2 = new Person("Ramzi White");
		Person p3 = new Person("Han Solo");
		Person p4 = new Person("Chewy");
		library.addPerson(p1);
		library.addPerson(p2);
		library.addPerson(p3);
		library.addPerson(p4);
		
		try{
			try {
				library.status();
				library.checkoutBook(b1, p1);
				library.checkoutBook(b2, p1);
				library.checkoutBook(b3, p2);
				library.checkoutBook(b4, p4);
				library.status();
				library.checkinBook(b1);
				library.checkinBook(b3);
				
				library.status();
				
			} finally{
				conn.close();
			}
		}catch (CheckOutException | MaxBooksException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
		}
		

	}

}

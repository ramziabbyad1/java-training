import java.sql.Date;



public class Book {

	String title;
	boolean checkedOut;
	int idBook;
	//Date datePub;
	public void setTitle(String title) {
		this.title = title;
	}

/*	public Date getDatePub() {
		return datePub;
	}

	public void setDatePub(Date datePub) {
		this.datePub = datePub;
	}*/

	public int getIdBook() {
		return idBook;
	}

	public void setIdBook(int idBook) {
		this.idBook = idBook;
	}

	public boolean isCheckedOut() {
		return checkedOut;
	}

	public void setCheckedOut(boolean checkedOut) {
		this.checkedOut = checkedOut;
	}

	@Override
	public String toString() {
		Person p = getPerson();
		if(!isCheckedOut()){
			return title + " is available";
		}
		else{
			return title + " checked out to " + p.getName() +".";
		}
	}

	public void getStatus() {
		if(checkedOut){
			System.out.println(getTitle()+getPerson()+"checkedout this book.");
		}else{
			System.out.println("This book is available for checkout");
		}
	}

	String author;
	Person person;

	public Book(String title) {
		this.title = title;
		this.author = "Unknown Author";
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setPerson(Person p2) {
		setCheckedOut(true);
		person = p2;
	}

	public Person getPerson() {
		return person;
	}

}

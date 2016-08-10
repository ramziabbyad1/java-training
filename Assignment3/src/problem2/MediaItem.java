package problem2;

class MediaItem {
	private String title;
	private boolean present;
	private int copyYear;
	private String runtime;
	public MediaItem(String title, boolean present, int copyYear, String runtime){
		this.title = title;
		this.present = present;
		this.copyYear = copyYear;
		this.runtime = runtime;
	}
	@Override
	public String toString() {
		return "MediaItem [title=" + title + ", present=" + present
				+ ", copyYear=" + copyYear + ", runtime="+runtime +"]";
	}
	
	public String getTime(){
		return runtime;
	}
	
	final public String getTitle() {
		return title;
	}

	final public boolean isPresent() {
		return present;
	}

	final public void setPresent(final boolean present) {
		this.present = present;
	}

	final public int getCopyYear() {
		return copyYear;
	}
}


/*
 * All media items have the following characteristics:

a title
a variable to track if that item is currently present in the collection
a playing time
a copyright year
Create appropriate instance variables for this data.

All media items have the following behaviors:

get the title
get the copyright year
get if the item is present in the collection
set the status of the item, in or out of the collection
get the playing time; it may be useful to get this information in several formats, for example in minutes or in hours and minutes
a toString method (of course! it is an Object!)


Create a CD class. CDs have the following additional characteristics and behaviors:

an artist
a number of tracks
a way to get the artist
a way to get the number of tracks

DVDs have the following additional characteristics and behaviors:

a rating, e.g., G, PG PG-13, R, NC-17. These examples are from the MPAA ratings system. There are different ratings systems in other countries so use a String for the rating. (What would be another appropriate way to represent these ratings?)
a length of time for the bonus features
a way to get the rating
a way to get the time of the bonus features
a way to get the total playing time of the DVD. (Note this should override MediaItem's method for getting the playing time.)

Books on tape have the following additional characteristics and behaviors:

an author
a narrator
a way to get the author
a way to get the narrator*/

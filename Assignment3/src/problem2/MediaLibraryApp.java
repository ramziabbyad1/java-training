package problem2;

public class MediaLibraryApp {

	public static void main(String[] args) {
		MediaItem[] item = new MediaItem[6];
		//CD runtimes are inpute/output in the hh:mm:ss format
		item[0] = new CD("The Rolling Stones", true, 1964, "33:24", "The Rolling Stones", 12);
		item[1] = new CD("The Pogues", false, 1984, "40:20", "Red Roses for Me", 13);
		//DVD runtimes are input/ouput in minutes
		item[2] = new DVD("Her", false, 2013, "126min", "MPAA: R", "0min");
		item[3] = new DVD("Forest Gump", true, 1994, "142min", "MPAA: PG-13", "20min");
		item[4] = new AudioBooks("Jack and Jill", false, 1996, "12hrs", "James Patterson", "Michael Kramer");
		item[5] = new AudioBooks("Beyond Good and Evil", true, 2012, "10hrs20mins", "Friedrich Nietzsche", "Unknown");
		
		//output the initial state of the library
		System.out.println("Initial state: ");
		for(MediaItem mi:item){
			System.out.println(mi);
		}
		//change status of some items
		item[0].setPresent(false);
		item[2].setPresent(true);
		//output new state of the library
		System.out.println("New state: ");
		for(MediaItem mi:item){
			System.out.println(mi);
		}
		

	}

}

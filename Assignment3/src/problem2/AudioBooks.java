package problem2;

class AudioBooks extends MediaItem{
	private String author;
	private String narrator;
	public AudioBooks(String title, boolean present, int copyYear, String runtime, String author, String narrator){
		super(title, present, copyYear, runtime);
		this.author = author;
		this.narrator = narrator;
	}
	@Override
	public String toString() {
		return "AudioBooks [title=" + getTitle() + ", present=" + isPresent()
				+ ", copyYear=" + getCopyYear()+ ", runtime="+getTime() +", author=" + author + ", narrator=" + narrator + "]";
	}

	public String getAuthor(){
		return author;
	}
	public String getNarrator(){
		return narrator;
	}
}

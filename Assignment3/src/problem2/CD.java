package problem2;

class CD extends MediaItem{
	private String artist;
	private int numTracks;
	public CD(String title, boolean present, int copyYear, String runtime, String artist, int numTracks){
		super(title, present, copyYear, runtime);
		this.artist = artist;
		this.numTracks = numTracks;
	}
	
	@Override
	public String toString() {
		return "CD [title=" + getTitle() + ", present=" + isPresent()
				+ ", copyYear=" + getCopyYear()+ ", runtime="+getTime() +", artist=" + artist + ", numTracks=" + numTracks
				 + "]";
	}

	final public String getArtist(){
		return artist;
	}
	final public int getNumTracks(){
		return numTracks;
	}
	
	
	
}

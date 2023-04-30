public class CD extends Item {
    private String _artist;
    private int _numberOfTracks;

    public CD(String title, int year, String artist, int tracks) {
        super(title, year);
        _artist = artist;
        _numberOfTracks = tracks;
    }

    public CD(CD other) {
        // if(other != null)
        this(other._title, other._publishYear, other._artist, other._numberOfTracks);
    }

    public String getArtist() {
        return _artist;
    }

    public int getNumberOfTracks() {
        return _numberOfTracks;
    }

    public void setArtist(String artist) {
        _artist = artist;
    }

    public void setNumberOfTracks(int tracks) {
        _numberOfTracks = tracks;
    }

    public String toString() {
        return "CD - " + super.toString() + "\tby: " + _artist + "\tNumber of tracks " + _numberOfTracks;
    }

    public void play() {
        System.out.println("Now playing " + _title + " by " + _artist + ", enjoy listening…");
    }
}

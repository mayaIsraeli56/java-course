public class Video extends Item {
    private String _director;

    public Video(String title, int year, String director) {
        super(title, year);
        _director = director;
    }

    public Video(Video other) {
        // if (other != null)
        this(other._title, other._publishYear, other._director);
    }

    public String getDirector() {
        return _director;
    }

    public void setDirector(String director) {
        _director = director;
    }

    public String toString() {
        return "Video - " + super.toString() + "\tdirected by: " + _director;
    }

    public void play() {
        System.out.println("Now playing " + _title + " directed by " + _director + ", enjoy watching…");
    }

    public boolean isOlder(int year) {
        return _publishYear < year;
    }

}

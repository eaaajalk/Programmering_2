package bibliotekssystem;

public class Film extends Media implements Sortable {
    private String director;

    public Film(String title, int releaseYear, String director) {
        super(title, releaseYear);
        this.director = director;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public int getYear() {
        return this.getReleaseYear();
    }
}

package bibliotekssystem;

public class Book extends Media implements Sortable {
    private String author;

    public Book(String title, int releaseYear, String author) {
        super(title, releaseYear);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }


    public void setAuthor(String author) {
        this.author = author;
    }
    @Override
    public int getYear() {
        return this.getReleaseYear();
    }

}


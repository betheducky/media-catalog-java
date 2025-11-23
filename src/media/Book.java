package media;
import media.interfaces.Previewable;

public class Book extends MediaItem implements Previewable{

    private String author;
    private int pageCount;

    public Book(String id, String title, String genre, String author, int pageCount) {
        
        super(id, title, genre);

        this.author = author;
        this.pageCount = pageCount;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPageCount() {
        return this.pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public static Book sortDeserialized(String[] fields) {
        return new Book(fields[0], fields[1], fields[2], fields[4], Integer.parseInt(fields[5]));
    }

    @Override
    public String getDetails() {
        return "Details for the book you have selected are as follow: " + getId() + ", " + getTitle() + ", " + getAuthor() + ", " + getGenre() + ", " + getPageCount();
    }

    @Override
    public void consume() {
        if(this.isAvailable()) {
            this.setAvailable(false);
            System.out.println("You have checked out the book, " + getTitle() + "!");
        } else {
            System.out.println("UnavailableException! " + getTitle() + " cannot be checked out; it is not available.");
        }
    }

    @Override
    public void preview() {
        System.out.println("Chapter 1: Once upon a time, in a land far, far away...");
    }

    @Override
    public String serializeExtra() {
        return "MOVIE|" + getAuthor() + "|" + getPageCount();
    }
}

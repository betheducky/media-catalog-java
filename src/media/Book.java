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

}

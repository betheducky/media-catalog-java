package media;

public abstract class MediaItem {
    private String id;
    private String title;
    private String genre;
    private boolean available;

    public MediaItem(String id, String title, String genre) {
        this.id = id;
        this.title = title;
        this.genre = genre;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return this.genre;
    }
    
    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean isAvailable() {
        return this.available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public abstract String getDetails();
    public abstract void consume();
    public abstract String serialize();
}

package media;

import library.exceptions.InvalidDataException;

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

    public String serialize() {
        return getId() + "|" + getTitle() + "|" + getGenre() + "|" + serializeExtra();
    }

    public static MediaItem deserialize(String line) throws InvalidDataException {
        String[] fields = line.split("\\|");
        MediaItem formattedItem;
        String itemType = fields[3];
                switch (itemType) {
                    case "BOOK":
                        formattedItem = Book.sortDeserialized(fields);
                        break;
                    case "MOVIE":
                        formattedItem = Movie.sortDeserialized(fields);
                        break;
                    case "AUDIOBOOK":
                        formattedItem = AudioBook.sortDeserialized(fields); 
                        break;
                    default:
                        throw new InvalidDataException(itemType + "is not a valid MediaItem type");
                }
                return formattedItem;
    }



    public abstract String getDetails();
    public abstract void consume();
    public abstract String serializeExtra();
}

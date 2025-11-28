package media;

import media.interfaces.Previewable;
import media.interfaces.Downloadable;

public class Movie extends MediaItem implements Previewable, Downloadable  {

    private int durationMinutes;
    private String director;
    private double rating;

    public Movie(String id, String title, String genre, boolean available, int durationMinutes, String director, Double rating) {
        
        super(id, title, genre, available);

        this.durationMinutes = durationMinutes;
        this.director = director;
        this.rating = rating;
    }

    public int getDurationMinutes() {
        return this.durationMinutes;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public String getDirector() {
        return this.director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Double getRating() {
        return this.rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

     public static Movie sortDeserialized(String[] fields) {
        return new Movie(fields[0], fields[1], fields[2], Boolean.parseBoolean(fields[3]), Integer.parseInt(fields[5]), fields[6], Double.parseDouble(fields[7]));
    }

    @Override
    public String getDetails() {
        return "ID: " + getId() + ", Title: " + getTitle() + ", Director: " + getDirector() + ", Genre: " + getGenre() + ", Movie Duration: " + getDurationMinutes() + ", Movie Rating: " + getRating() + ", Available: " + isAvailable();
    }

    @Override
    public void consume() {
        if(this.isAvailable()){
            this.setAvailable(false);
            System.out.println("You are now playing the movie, " + getTitle() + "!");
        } else {
            System.out.println("UnavailableException! " + getTitle() + " cannot be played unless it is available.");
        }
    }

    @Override
    public void preview() {
        System.out.println("*Intro music plays* NARRATOR: IN A WORLD...");
    }

    @Override
    public void download() {
        if(this.isAvailable()) {
            System.out.println("Downloading movie...");
        } else {
            System.out.println("UnavailableException! " + getTitle() + " is not available to download.");
        }
    }

    @Override
    public String serializeExtra() {
        return "MOVIE|" + getDurationMinutes() + "|" + getDirector() + "|" + getRating();
    }
}

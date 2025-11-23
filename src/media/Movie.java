package media;

import media.interfaces.Previewable;
import media.interfaces.Downloadable;

public class Movie extends MediaItem implements Previewable, Downloadable  {

    private int durationMinutes;
    private String director;
    private double rating;

    public Movie(String id, String title, String genre, int durationMinutes, String director, Double rating) {
        
        super(id, title, genre);

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
        return new Movie(fields[0], fields[1], fields[2], Integer.parseInt(fields[4]), fields[5], Double.parseDouble(fields[6]));
    }

    @Override
    public String getDetails() {
        return "Details for the movie you have selected are as follow: " + getId() + ", " + getTitle() + ", " + getDirector() + ", " + getGenre() + ", " + getDurationMinutes() + ", " + getRating();
    }

    @Override
    public void consume() {
        if(this.isAvailable()){
            this.setAvailable(false);
            System.out.println("You have checked out the movie, " + getTitle() + "!");
        } else {
            System.out.println("UnavailableException! " + getTitle() + " cannot be checked out; it is not available.");
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

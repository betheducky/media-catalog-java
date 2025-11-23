package media;

import media.interfaces.Downloadable;

public class AudioBook extends MediaItem implements Downloadable {

    private String narrator;
    private double lengthHours;

    public AudioBook(String id, String title, String genre, String narrator, double lengthHours) {

        super(id, title, genre);

        this.narrator = narrator;
        this.lengthHours = lengthHours;
    }

    public String getNarrator() {
        return this.narrator;
    }

    public void setNarrator(String narrator) {
        this.narrator = narrator;
    }

    public double getLengthHours() {
        return this.lengthHours;
    }

    public void setLengthHours(double lengthHours) {
        this.lengthHours = lengthHours;
    }

    public static AudioBook sortDeserialized(String[] fields) {
        return new AudioBook(fields[0], fields[1], fields[2], fields[4], Integer.parseInt(fields[5]));
    }

    @Override
    public String getDetails() {
        return "Details for the audiobook you have selected are as follow: " + getId() + ", " + getTitle() + ", " + getNarrator() + ", " + getGenre() + ", " + getLengthHours();
    }

    @Override
    public void consume() {
        if(this.isAvailable()){
            System.out.println("You have checked out the audiobook, " + getTitle() + "!");
        } else {
            System.out.println(getTitle() + " cannot be checked out; it is not available.");
        }
    }

    @Override
    public void download() {
        if(this.isAvailable()) {
            this.setAvailable(false);
            System.out.println("You have checked out the movie, " + getTitle() + "!");
        } else {
            System.out.println("UnavailableException! " + getTitle() + " is not available to download.");
        }
    }

    @Override
    public String serializeExtra() {
        return "MOVIE|" + getNarrator() + "|" + getLengthHours();
    }

}
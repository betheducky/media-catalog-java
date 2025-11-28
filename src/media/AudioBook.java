package media;

import media.interfaces.Downloadable;

public class AudioBook extends MediaItem implements Downloadable {

    private String narrator;
    private double lengthHours;

    public AudioBook(String id, String title, String genre, boolean available, String narrator, double lengthHours) {

        super(id, title, genre, available);

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
        return new AudioBook(fields[0], fields[1], fields[2], Boolean.parseBoolean(fields[3]), fields[4], Integer.parseInt(fields[5]));
    }

    @Override
    public String getDetails() {
        return "ID: " + getId() + ", Title: " + getTitle() + ", Narrator: " + getNarrator() + ", Genre: " + getGenre() + ", AudioBook Length: " + getLengthHours() + ", Available: " + isAvailable();
    }

    @Override
    public void consume() {
        if(this.isAvailable()){
            System.out.println("You are now listening to the audiobook, " + getTitle() + "!");
        } else {
            System.out.println(getTitle() + " cannot be listened to unless it is available.");
        }
    }

    @Override
    public void download() {
        if(this.isAvailable()) {
            this.setAvailable(false);
            System.out.println("You are now downloading the audiobook, " + getTitle() + "!");
        } else {
            System.out.println("UnavailableException! " + getTitle() + " is not available to download.");
        }
    }

    @Override
    public String serializeExtra() {
        return "AUDIOBOOK|" + getNarrator() + "|" + getLengthHours();
    }

}
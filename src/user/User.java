package user;

import media.MediaItem;
import java.util.List;
import java.util.ArrayList;

public class User {

    private String name;
    private List<MediaItem> borrowedItems = new ArrayList<>();
    private List<MediaItem> favorites = new ArrayList<>();

    public User(String name) {

        this.name = name;
        
    }

    public String getName() {
        return this.name;
    }

    public void borrowItem(MediaItem item) {
        if(!borrowedItems.contains(item) && item.isAvailable()) {
            item.setAvailable(false);
            borrowedItems.add(item);
            System.out.println();
            System.out.println(item.getTitle() +" has been borrowed.");
            System.out.println("Updated borrowed items list: " + getBorrowed());
            System.out.println();
        } else {
            System.out.println("UnavailableItemException! Item cannot be borrowed.");
            System.out.println();
        }
    }

    public void returnItem(MediaItem item) {
        if(borrowedItems.contains(item)) {
            borrowedItems.remove(item);
            item.setAvailable(true);
            System.out.println(item.getTitle() + " has been returned.");
            System.out.println("Updated borrowed items list: " + getBorrowed());
            System.out.println();
        } else {
            System.out.println("ItemNotFoundException! " + item.getTitle() + " cannot be found to return.");
        }
    }

    public void favoriteItem(MediaItem item) {
        if(!favorites.contains(item)) {
            favorites.add(item);
            System.out.println(item.getTitle() +" has been added to favorites.");
            System.out.println();
        } else {
            System.out.println("Item was already added to favorites! No action taken.");
            System.out.println();
        }
    }

    public List<String> getBorrowed() {
        List<String> borrowedTitles = new ArrayList<>();
        for(MediaItem item : borrowedItems) {
            borrowedTitles.add(item.getTitle());
        };
        return borrowedTitles;
    }

    public List<String> getFavorites() {
        List<String> favoriteTitles = new ArrayList<>();
        for(MediaItem item : borrowedItems) {
            favoriteTitles.add(item.getTitle());
        };
        return favoriteTitles;    
    }
}

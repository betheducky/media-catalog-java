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
            System.out.println(item +" has been successfully borrowed.");
        } else {
            System.out.println("UnavailableItemException! Item cannot be borrowed.");
        }
    }

    public void returnItem(MediaItem item) {
        if(borrowedItems.contains(item)) {
            borrowedItems.remove(item);
            item.setAvailable(true);
        } else {
            System.out.println("ItemNotFoundException! " + item + " cannot be found to return.");
        }
    }

    public void favoriteItem(MediaItem item) {
        if(!favorites.contains(item)) {
            favorites.add(item);
            System.out.println(item +" has been added to favorites.");
        } else {
            System.out.println("Item was already added to favorites! No action taken.");
        }
    }

    public List<MediaItem> getBorrowed() {
        return this.borrowedItems;
    }

    public List<MediaItem> getFavorites() {
        return this.favorites;
    }
}

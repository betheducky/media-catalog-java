package library;

import media.MediaItem;
import library.exceptions.InvalidDataException;
import library.persistence.FileHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LibraryManager {

    private List<MediaItem> catalog = new ArrayList<>();

    public LibraryManager(List<MediaItem> catalog) {
        this.catalog = catalog;
    }

    public void addItem(MediaItem item) {
        catalog.add(item);
        System.out.println(item + " has been added to catalog.");
    }

    public void removeItem(String itemId) {
       MediaItem selectedItem = findById(itemId);
       catalog.remove(selectedItem);
       System.out.println(selectedItem + " has been removed from catalog.");
    }

    public MediaItem findById(String id) {
        for(MediaItem item : catalog) {
            if(item.getId().equals(id)){
                return item;
            }
        }
        return null;
    }

    public List<MediaItem> searchByTitle(String title) {
        List<MediaItem> searchResult = new ArrayList<MediaItem>();
        for(MediaItem item : catalog) {
            if(item.getTitle().contains(title)){
                searchResult.add(item);
            }
        }
        return searchResult;
    }

    public List<MediaItem> filterByGenre(String genre) {
        List<MediaItem> filterResult = new ArrayList<MediaItem>();
        for(MediaItem item : catalog) {
            if(item.getGenre().equals(genre)){
                filterResult.add(item);
            }
        }
        return filterResult;
    }

    public void loadCatalog(String path) throws InvalidDataException, IOException {
        FileHandler handler = new FileHandler();
        this.catalog = handler.loadCatalog(path);
    }

    public void displayCatalog() {
        if(catalog.size() > 0) {
            for (MediaItem item : catalog) {
            System.out.println(item.toString());
        }
        } else {
            System.out.println();
            System.out.println("No items in Catalog! \n Add an item first!");
            System.out.println();
        }
        
    }

    public List<MediaItem> getCatalog() {
        return new ArrayList<>(catalog);
    }

    public void consumeItem(String id) {
        MediaItem item = findById(id);
        
        if(item != null) {
            item.consume();
        } else {
            System.out.println("Item not found!");
        }
    }
    
}

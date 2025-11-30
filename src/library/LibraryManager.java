package library;

import media.MediaItem;
import util.DemoData;
import library.exceptions.InvalidDataException;
import library.persistence.FileHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LibraryManager {

    private List<MediaItem> catalog;

    public LibraryManager() {
        this.catalog = new ArrayList<>();
        DemoData.loadData(this.catalog);
    }

    public void addItem(MediaItem item) {
        catalog.add(item);
        System.out.println();
        System.out.println(item.getTitle() + " has been added to catalog.");
        System.out.println();

    }

    public void removeItem(String itemId) {
       MediaItem selectedItem = findById(itemId);
       catalog.remove(selectedItem);
       System.out.println();
       System.out.println(selectedItem.getTitle() + " has been removed from catalog.");
       System.out.println();
    }

    public MediaItem findById(String id) {
        for(MediaItem item : catalog) {
            if(id.equals(item.getId())){
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
            System.out.println();
            System.out.println("Item count: " + catalog.size());
            for (MediaItem item : catalog) {
            System.out.println();
            System.out.println(item.getDetails());
            System.out.println();
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

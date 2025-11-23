package library.persistence;

import media.MediaItem;
import library.LibraryManager;
import library.exceptions.InvalidDataException;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

import java.util.ArrayList;
import java.io.IOException;


public class FileHandler {
    public void saveCatalog(LibraryManager manager, String path) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            for (MediaItem item : manager.getCatalog()) {

                CatalogParser formatter = new CatalogParser();
                writer.write(formatter.handleSerialize(item));
                writer.newLine();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<MediaItem> loadCatalog(String path) throws InvalidDataException, IOException {
        List<MediaItem> loadedCatalog = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {

            String line; 
            CatalogParser formatter = new CatalogParser();
            
            while ((line = reader.readLine()) != null) {
                loadedCatalog.add(formatter.handleDeserialize(line));
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return loadedCatalog;
    }
}

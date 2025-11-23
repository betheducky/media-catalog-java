package library.persistence;

import media.MediaItem;

import library.exceptions.InvalidDataException;

public class CatalogParser {

    public String handleSerialize(MediaItem item) {
        return item.serialize();
    }

    public MediaItem handleDeserialize(String line) throws InvalidDataException {
       return MediaItem.deserialize(line);
    }
    
}

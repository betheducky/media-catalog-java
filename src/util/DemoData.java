package util;

import java.util.List;

import media.AudioBook;
import media.Book;
import media.MediaItem;
import media.Movie;

public class DemoData {

    public static void loadData(List<MediaItem> catalog) {
        catalog.add(new Book("1", "The BFG", "Fiction", true, "Roald Dahl", 300));
        catalog.add(new Movie("2", "Star Wars", "Fantasy", true, 160, "George Lucas", 4.6));
        catalog.add(new AudioBook("3", "The Farmer's Daughter", "Romance", true, "Gwenyth Paltrow", 3));
        catalog.add(new Book("4", "To Kill a Mockingbird", "Fiction", true, "Harper Lee", 336));
        catalog.add(new Movie("5", "Inception", "Sci-Fi", true, 148, "Christopher Nolan", 4.8));
        catalog.add(new AudioBook("6", "Becoming", "Biography", true, "Michelle Obama", 19));
        catalog.add(new Book("7", "The Hobbit", "Fantasy", true, "J.R.R. Tolkien", 310));
        catalog.add(new Movie("8", "The Shawshank Redemption", "Drama", true, 142, "Frank Darabont", 4.9));
        catalog.add(new AudioBook("9", "Atomic Habits", "Self-Help", true, "James Clear", 5));
        catalog.add(new Book("10", "Pride and Prejudice", "Romance", true, "Jane Austen", 279));
        catalog.add(new Movie("11", "The Dark Knight", "Action", true, 152, "Christopher Nolan", 4.7));
        catalog.add(new AudioBook("12", "Dune", "Sci-Fi", true, "Simon Vance", 21));
        catalog.add(new Book("13", "The Catcher in the Rye", "Fiction", true, "J.D. Salinger", 277));
        catalog.add(new Movie("14", "The Matrix", "Sci-Fi", true, 136, "Lana Wachowski & Lilly Wachowski", 4.8));
        catalog.add(new AudioBook("15", "Educated", "Memoir", true, "Tara Westover", 12));
    }
}

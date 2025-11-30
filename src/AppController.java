
import library.LibraryManager;
import util.InputHelper;
import user.User;
import media.Book;
import media.Movie;
import media.interfaces.Previewable;
import media.AudioBook;
import media.MediaItem;
import java.util.List;

public class AppController {

    private LibraryManager manager;
    private User user;

    public AppController(LibraryManager manager, User user) {
        this.manager = manager;
        this.user = user;
    }

        public void start() {

            boolean running = true;

            while(running) {
                showMenu();

                int choice = InputHelper.readInt("Choose an option: ");

                switch(choice) {
                    case 1 -> addMedia();
                    case 2 -> listMedia();
                    case 3 -> listBorrowed();
                    case 4 -> borrowMedia();
                    case 5 -> returnMedia();
                    case 6 -> previewMedia();
                    case 7 -> consumeMedia();
                    case 8 -> searchMedia();
                    case 0 -> {
                        System.out.println("Exiting...");
                        running = false;
                    }
                    default -> {
                        System.out.println("Invalid option");
                        System.out.println();
                }
                }
            }
            System.out.println("Goodbye!");
            System.out.println();
        }

        private void showMenu(){
            System.out.println("\n=== Media Library ===");
            System.out.println("1. Add a media item");
            System.out.println("2. List all items");
            System.out.println("3. List borrowed items");
            System.out.println("4. Borrow an item");
            System.out.println("5. Return an item");
            System.out.println("6. Preview an item");
            System.out.println("7. Demo an item!");
            System.out.println("8. Search media items");
            System.out.println("0. Exit");
            System.out.println();
        }

        private void addMedia() {
            System.out.println("\n What kind of item?");
            System.out.println("1. Book");
            System.out.println("2. Movie");
            System.out.println("3. AudioBook");
            System.out.println("4. Return to prevoious menu");
            System.out.println();

            int type = InputHelper.readInt("Select an option: ");
            if(type == 4) {
                System.out.println("Returning to main menu...");
                return;
            };

            String id = InputHelper.readString("ID: ");
            String title = InputHelper.readString("Title: ");
            String genre = InputHelper.readString("Genre: ");
            System.out.println();
            boolean available = true;

            switch(type) {
                case 1 -> {
                    String author = InputHelper.readString("Author: ");
                    int pageCount = InputHelper.readInt("Page Count: ");
                    manager.addItem(new Book(id, title, genre, available, author, pageCount)); 
                    System.out.println();
                }

                case 2 -> {
                    int duration = InputHelper.readInt("Duration in minutes: ");
                    String director = InputHelper.readString("Director: ");
                    Double rating = InputHelper.readDouble("Rating: ");
                    manager.addItem(new Movie(id, title, genre, available, duration, director, rating));
                    System.out.println();
                }

                case 3 -> {
                    String narrator = InputHelper.readString("Narrator: ");
                    int length = InputHelper.readInt("Length in Minutes: ");
                    manager.addItem(new AudioBook(id, title, genre, available, narrator, length));
                    System.out.println();
                }
            }
        }

        private void listMedia() {
            manager.displayCatalog();
        }

        private void listBorrowed() {
            System.out.println("Current borrowed item list: " + user.getBorrowed());
            System.out.println();
        }

        private void borrowMedia() {
            String id = InputHelper.readString("Enter ID: ");
            System.out.println();

            try {
                MediaItem item = manager.findById(id);
                user.borrowItem(item);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        private void returnMedia() {
            String id = InputHelper.readString("Enter ID: ");

            try {
                MediaItem item = manager.findById(id);
                user.returnItem(item);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        private void previewMedia() {
            String id = InputHelper.readString("Enter ID: ");
            MediaItem item = manager.findById(id);

            if(item instanceof Previewable p) {
                p.preview();
            } else {
                System.out.println("This item cannot be previewed");
            }
            System.out.println();
        }

        private void consumeMedia() {
            String id = InputHelper.readString("Enter ID: ");
            manager.consumeItem(id);
            System.out.println();
        }

        private void searchMedia() {
            System.out.println("1. Search by ID");
            System.out.println("2. Search by Title");
            System.out.println("3. Search by Genre");
            System.out.println("4. Return to previous menu");
            System.out.println();
            int type = InputHelper.readInt("Choose an option: ");

            switch(type) {
                case 1 -> {
                    String id = InputHelper.readString("Search IDs: ");
                    MediaItem result = manager.findById(id);
                    if(result == null) {
                        System.out.println("No result for that search!");
                        searchMedia();
                    } else {
                        System.out.println("Search result: " + result.getDetails());
                    }
                }
                case 2 -> {
                    String title = InputHelper.readString("Search titles: ");
                    List<MediaItem> result = manager.searchByTitle(title); 
                    System.out.println("Search result: ");
                    if(result.isEmpty()){
                        System.out.println("No results for that search!");
                        searchMedia();
                    } else {
                        for(MediaItem item : result) {
                        System.out.println(item.getDetails());
                    };
                    }
                    
                }

                case 3 -> {
                    String genre = InputHelper.readString("Search genres: ");
                    List<MediaItem> result = manager.filterByGenre(genre);
                    System.out.println("Search result: ");
                    if(result.isEmpty()){
                        System.out.println("No results for that search!");
                        searchMedia();
                    } else {
                        for(MediaItem item : result) {
                        System.out.println(item.getDetails());
                    }
                    }
                    
                }

                case 4 -> {
                    System.out.println("Returning to previous menu...");
                    return;
                }

                default -> {
                    System.out.println("Invalid selection.");
                    searchMedia();
                }
            }
        }

    }

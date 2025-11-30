
import library.LibraryManager;
import util.InputHelper;
import user.User;
import media.Book;
import media.Movie;
import media.interfaces.Previewable;
import media.AudioBook;
import media.MediaItem;

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
                    case 0 -> {
                        System.out.println("Exiting...");
                        running = false;
                    }
                    default -> System.out.println("Invalid option");
                }
            }
            System.out.println("Goodbye!");
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
            System.out.println("0. Exit");
        }

        private void addMedia() {
            System.out.println("\n What kind of item?");
            System.out.println("1. Book");
            System.out.println("2. Movie");
            System.out.println("3. AudioBook");

            int type = InputHelper.readInt("Type: ");

            String id = InputHelper.readString("ID: ");
            String title = InputHelper.readString("Title: ");
            String genre = InputHelper.readString("Genre: ");
            boolean available = true;

            switch(type) {
                case 1 -> {
                    String author = InputHelper.readString("Author: ");
                    int pageCount = InputHelper.readInt("Page Count: ");
                    manager.addItem(new Book(id, title, genre, available, author, pageCount)); 
                }

                case 2 -> {
                    int duration = InputHelper.readInt("Duration in minutes: ");
                    String director = InputHelper.readString("Director: ");
                    Double rating = InputHelper.readDouble("Rating: ");
                    manager.addItem(new Movie(id, title, genre, available, duration, director, rating));
                }

                case 3 -> {
                    String narrator = InputHelper.readString("Narrator: ");
                    int length = InputHelper.readInt("Length in Minutes: ");
                    manager.addItem(new AudioBook(id, title, genre, available, narrator, length));
                }
            }
        }

        private void listMedia() {
            manager.displayCatalog();
        }

        private void listBorrowed() {
            System.out.println("Current borrowed item list: " + user.getBorrowed());
        }

        private void borrowMedia() {
            String id = InputHelper.readString("Enter ID: ");

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
        }

        private void consumeMedia() {
            String id = InputHelper.readString("Enter ID: ");
            manager.consumeItem(id);
        }

    }

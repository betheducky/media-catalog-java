
import library.LibraryManager;
import util.InputHelper;
import user.User;

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
                    case 3 -> borrowMedia();
                    case 4 -> returnMedia();
                    case 5 -> previewMedia();
                    case 6 -> consumeMedia();
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
            System.out.println("3. Borrow an item");
            System.out.println("4. Return an item.");
            System.out.println("5. Preview an item.");
            System.out.println("6. Demo an item!");
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

            switch(type) {
                
            }
        }
}

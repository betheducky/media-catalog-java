import library.LibraryManager;
import util.InputHelper;

public class AppController {

    private LibraryManager manager;
    private InputHelper input;

    public AppController(LibraryManager manager, InputHelper input) {
        this.manager = manager;
        this.input = input;
    }

        public void start() {

            boolean running = true;

            while(running) {
                showMenu();

                int choice = input.readInt("Choose an option: ");

                switch(choice) {
                    case 1 -> createMediaItem();
                    case 2 -> listItems();
                    case 3 -> previewItem();
                    case 0 -> running = false;
                    default -> System.out.println("Invalid option");
                }
            }
            System.out.println("Goodbye!");
        }

        private void showMenu(){
            System.out.println("\n=== Media Library ===");
            System.out.println("1. Add a media item");
            System.out.println("2. List all items");
            System.out.println("3. Preview an item");
            System.out.println("0. Exit");
        }

        private void createMediaItem() {
            System.out.println("\n What kind of item?");
            System.out.println("1. Book");
            System.out.println("2. Movie");
            System.out.println("3. AudioBook");

            int type = input.readInt("Choose: ");
        }
}

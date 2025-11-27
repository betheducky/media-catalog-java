import library.LibraryManager;
import media.MediaItem;
import user.User;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main (String[] args) {
        List<MediaItem> catalog = new ArrayList<MediaItem>();
        LibraryManager manager = new LibraryManager(catalog);
        User user = new User("Aren");
        AppController controller = new AppController(manager, user);

        controller.start();
    }
}

import library.LibraryManager;
import util.InputHelper;
import user.User;

public class Main {
    public static void main (String[] args) {
        LibraryManager manager = new LibraryManager(null);
        InputHelper input = new InputHelper();
        AppController controller = new AppController();

        controller.start();
    }
}

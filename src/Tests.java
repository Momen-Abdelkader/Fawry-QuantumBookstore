import java.time.Year;
import java.util.List;

public class Tests {
    public static void runAllTests() {
        runAddBookTest();
        runCreateBookInvalidQuantityTest();
        runCreateBookInvalidPriceTest();
        runRemoveBookTest();
        runRemoveNonExistentBookTest();
        runRemovingOutDatedBooksTest();
    }

    public static void runAddBookTest() {
        System.out.println("\n------ Add Book Test ------");
        try {
            BookStore store = new BookStore();
            PaperBook book = new PaperBook("1234567890", "Added book", Year.now().getValue(), 10.0, 10, 1.0);
            store.addBook(book);
            System.out.println("Book added successfully: " + book);
        }
        catch (Exception e) {
            System.out.println("Failed to add book: " + e.getMessage());
        }
    }

    public static void runCreateBookInvalidQuantityTest() {
        System.out.println("\n------ Create Book Invalid Invalid Quantity Test ------");
        try {
            BookStore store = new BookStore();
            PaperBook book = new PaperBook("1234567890", "Added book", Year.now().getValue(), 10.0, -1, 1.0);
            store.addBook(book);
            System.out.println("Book added successfully: " + book);
        }
        catch (Exception e) {
            System.out.println("Failed to add book: " + e.getMessage());
        }
    }

    public static void runCreateBookInvalidPriceTest() {
        System.out.println("\n------ Create Book Invalid Invalid Price Test ------");
        try {
            BookStore store = new BookStore();
            PaperBook book = new PaperBook("1234567890", "Added book", Year.now().getValue(), -10.0, 10, 1.0);
            store.addBook(book);
            System.out.println("Book added successfully: " + book);
        }
        catch (Exception e) {
            System.out.println("Failed to add book: " + e.getMessage());
        }
    }

    public static void runRemoveBookTest() {
        System.out.println("\n------ Remove Book Test ------");
        try {
            BookStore store = new BookStore();
            PaperBook book = new PaperBook("1234567890", "Removed book", Year.now().getValue(), 10.0, 10, 1.0);
            store.addBook(book);
            System.out.println("Book added successfully: " + book);
            store.removeBook(book);
            System.out.println("Book removed successfully: " + book);
        }
        catch (Exception e) {
            System.out.println("Failed to remove book: " + e.getMessage());
        }
    }

    public static void runRemoveNonExistentBookTest() {
        System.out.println("\n------ Remove Non Existent Book Test ------");
        try {
            BookStore store = new BookStore();
            PaperBook book = new PaperBook("1234567890", "Non existent book", Year.now().getValue(), 10.0, 10, 1.0);
            System.out.println("Removing: " + book);
            store.removeBook(book);
            System.out.println("Book removed successfully: " + book);
        }
        catch (Exception e) {
            System.out.println("Failed to remove book: " + e.getMessage());
        }
    }

    public static void runRemovingOutDatedBooksTest() {
        System.out.println("\n------ Remove Outdated Books Test ------");
        try {
            BookStore store = new BookStore();
            int currentYear = Year.now().getValue();
            PaperBook outdatedBook = new PaperBook("1", "Outdated Book", currentYear - 20, 10.0, 5, 1.0);
            PaperBook outdatedBook2 = new PaperBook("2", "Outdated Book2", currentYear - 16, 10.0, 5, 1.0);
            PaperBook currentBook = new PaperBook("3", "Current Book", currentYear, 10.0, 5, 1.0);
            store.addBook(outdatedBook);
            store.addBook(outdatedBook2);
            store.addBook(currentBook);
            System.out.println("Book added: " + outdatedBook);
            System.out.println("Book added: " + outdatedBook2);
            System.out.println("Book added: " + currentBook);
            List<Book> removed = store.removeOutDatedBooks(10);

            System.out.println("Removed Books (maxYearsPassed = 10): ");
            for (Book book : removed) {
                System.out.println(book);
            }
        }
        catch (Exception e) {
            System.out.println("Test failed: " + e.getMessage());
        }
    }
}

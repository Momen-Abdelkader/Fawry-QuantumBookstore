import java.util.List;

public class Bookstore {
    private final Inventory inventory = new Inventory();

    public void addBook(Book book) {
        inventory.addBook(book);
    }

    public void removeBook(Book book) {
        inventory.removeBook(book);
    }

    public List<Book> removeOutDatedBooks(int maxYearsPassed) {
        return inventory.removeOutDatedBooks(maxYearsPassed);
    }

    public double buyBook(String isbn, int quantity, String email, String address) {
        Book book = inventory.getBook(isbn);
        if (book == null) {
            throw new IllegalArgumentException("Book not found in inventory.");
        }

        if (!book.isPurchasable()) {
            throw new IllegalArgumentException("Book is not purchasable.");
        }

        if (book instanceof IShippable shippable) {
            if (!shippable.isAvailable(quantity)) {
                throw new IllegalArgumentException(String.format("insufficient stock for %s. available stock: %d, requested stock: %d", book.getTitle(), shippable.getStock(), quantity));
            }
            shippable.reduceStock(quantity);
            ShippingService.ship(book, quantity, address);
        }
        else if (book instanceof IDigital emailable) {
            MailService.sendEmail(book, email, emailable.getFileType());
        }

        return book.getPrice() * quantity;
    }
}

# Quantum-Bookstore
My solution to Fawry N² Dev Slope #10 Challenge

# Description
An implementation for a Bookstore System that handles different types of books (physical, digital, showcase), inventory management, purchasing, and fulfillment operations. The system supports adding/removing books, purchasing shippable books, emailing digital books, and managing showcase items that aren't purchasable. All required validation is implemented for invalid states (outdated books, insufficient stock, invalid prices, etc.). The design follows SOLID principles with clear abstraction between book types and their behaviors.

# Main Components

## Interfaces

- `IDigital.java` - Interface for digital books requiring file type management and mailing.

- `IShippable.java` - Interface for shippable books requiring stock management and shipping operations.

## Store Classes

- `BookStore.java` - Main bookstore handling book addition, removal, and purchase operations.

- `Inventory.java` - Manages book inventory with ISBN-based storage and outdated book removal.

- `ShippingService.java` - Demo service for handling shipping.

- `MailService.java` - Demo service for email delivery for digital books.

## Book Classes

- `Book.java` - Abstract base class defining core book properties (ISBN, title, year, price) and purchasable status.

- `PaperBook.java` - Shippable book implementation supporting stock management and shipping (implements IShippable).

- `EBook.java` - Digital book implementation supporting file formats (implements IDigital).

- `ShowcaseBook.java` - Special display book type that is not purchasable.

## Tests.java class
This class contains methods for testing the store's functionality and validation with logging:

- `runAllTests()` - Executes all test cases sequentially
- `runAddBookTest()` - Tests adding valid books to inventory
- `runCreateBookInvalidQuantityTest()` - Tests book creation with negative stock quantity
- `runCreateBookInvalidPriceTest()` - Tests book creation with negative prices
- `runRemoveBookTest()` - Tests removing existing books from inventory
- `runRemoveNonExistentBookTest()` - Tests removing non-existent books
- `runRemovingOutDatedBooksTest()` - Tests removing books older than specified threshold
- `runBuyShippableBookTest()` - Tests purchasing shippable books (PaperBook)
- `runBuyDigitalBookTest()` - Tests purchasing digital books (EBook)
- `runBuyNonPurchasableBookTest()` - Tests purchasing non-purchasable books (ShowcaseBook)
- `runBuyNonExistentBookTest()` - Tests purchasing non-existent books
- `runBuyOutOfStockBookTest()` - Tests purchasing out-of-stock books


# How to run the tests
The tests cover all critical system operations including:

- Adding valid/invalid books
- Removing books
- Removing outdated books.
- Purchasing physical books (shipping)
- Purchasing digital books (email delivery)
- Handling non-purchasable books
- Error cases (out of stock, non-existent books)

## Method 1
- Run `Main.java` through and IDE.

## Method 2
- Compile and run the `Main.java` main class through terminal:
```bash
javac *.java
java Main
```

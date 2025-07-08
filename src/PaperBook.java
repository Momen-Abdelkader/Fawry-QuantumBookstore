public class PaperBook extends Book implements IShippable {
    private int stock;
    private double weight;

    public PaperBook(String isbn, String title, int year, double price, int stock, double weight) {
        super(isbn, title, year, price);

        if (stock < 0) {
            throw new IllegalArgumentException("Stock cannot be negative.");
        }

        this.stock = stock;

        if (weight <= 0) {
            throw new IllegalArgumentException("Weight must be greater than 0");
        }

        this.weight = weight;
    }

    @Override
    public int getStock() {
        return stock;
    }

    @Override
    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public void reduceStock(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative.");
        }

        if (quantity > stock) {
            throw new IllegalArgumentException(String.format("insufficient stock for %s. available stock: %d, requested stock: %d", getTitle(), stock, quantity));
        }

        stock -= quantity;
    }

    @Override
    public void increaseStock(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative.");
        }

        stock += quantity;
    }

    @Override
    public boolean isAvailable(int requestedQuantity) {
        return stock >= requestedQuantity;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}

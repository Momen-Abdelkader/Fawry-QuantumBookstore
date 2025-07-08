public class PaperBook extends Book implements IShippable {
    private int stock;
    private int weight;

    public PaperBook(String isbn, String title, int year, double price, int stock) {
        super(isbn, title, year, price);
        this.stock = stock;
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
    public double getWeight() {
        return weight;
    }
}

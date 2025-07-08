public interface Shippable {
    public int getStock();
    public void setStock(int stock);
    public void reduceStock(int quantity);
    public void increaseStock(int quantity);
    public double getWeight();
}

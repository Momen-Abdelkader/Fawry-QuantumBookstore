package com.bookstore.interfaces;

public interface IShippable {
    public int getStock();
    public void setStock(int stock);
    public void reduceStock(int quantity);
    public void increaseStock(int quantity);
    public boolean isAvailable(int requestedQuantity);
    public double getWeight();
}

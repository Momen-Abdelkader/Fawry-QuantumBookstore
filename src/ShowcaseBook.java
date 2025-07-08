class ShowcaseBook extends Book {
    public ShowcaseBook(String isbn, String title, int year, double price) {
        super(isbn, title, year, price);
    }

    @Override
    public boolean isPurchasable() {
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + " -> Showcase Book";
    }
}


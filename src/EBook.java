public class EBook extends Book implements IEmailable {
    private final String fileType;

    public EBook(String isbn, String title, int year, double price, String fileType) {
        super(isbn, title, year, price);
        this.fileType = fileType;
    }

    @Override
    public String getFileType() {
        return fileType;
    }
}

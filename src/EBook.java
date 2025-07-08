public class EBook extends Book implements IDigital {
    private String fileType;

    public EBook(String isbn, String title, int year, double price, String fileType) {
        super(isbn, title, year, price);
        this.fileType = fileType;
    }

    @Override
    public String getFileType() {
        return fileType;
    }

    @Override
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
}
